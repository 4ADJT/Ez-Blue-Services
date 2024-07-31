package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.domain.payment.RegisterPayment;
import br.com.ezblue.ezblueservices.openfeign.EzBoundaryServiceOpenFeign;
import br.com.ezblue.ezblueservices.openfeign.EzClientServiceOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ParkingComponent {

    @Autowired
    EzClientServiceOpenFeign ezClientServiceOpenFeign;

    @Autowired
    EzBoundaryServiceOpenFeign ezBoundaryServiceOpenFeign;

    private Map<String, Object> getClientById(UUID clientId) {
        return ezClientServiceOpenFeign.getClientById(clientId);
    }

    public boolean validateClientVehicle(UUID clientId, UUID vehicleId) {
        var clientEntity = getClientById(clientId);

        boolean clientExists = clientEntity.get("id").toString()
                .equals(clientId.toString());

        var vehicleList = (ArrayList<Map<String, Object>>) clientEntity.get("vehicle");

        boolean veicileExists = vehicleList.stream()
                .anyMatch(vehicle -> vehicle.get("id").toString()
                        .equals(vehicleId.toString())
                );

        return clientExists && veicileExists;
    }

    public Map<String, Object> boundaryService(DetailParking detailParking, RegisterParking registerParking, Double rateValue) {
        String clientEmail = getClientById(registerParking.clientId()).get("email").toString();
        notificationBoundaryService(detailParking, registerParking, clientEmail);
        return paymentBoundaryService(detailParking, registerParking, rateValue);
    }

    private Map<String, Object> paymentBoundaryService(DetailParking detailParking, RegisterParking registerParking, Double rateValue) {
        return ezBoundaryServiceOpenFeign.createPayment(
                paymentObject(
                        detailParking.clientId(),
                        registerParking.payment(),
                        rateValue
                )
        );
    }

    private Map<String, Object> paymentObject(UUID uuid, RegisterPayment payment, Double rateValue) {
        var clientEntity = getClientById(uuid);
        String clientID = clientEntity.get("id").toString();
        Map<String, Object> json = new HashMap<>();

        json.put("customerId", clientID);
        json.put("type", payment.paymentType());
        json.put("value", rateValue);

        if (payment.paymentType().equals("PIX")) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", payment.key());
            json.put("pix", map);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("type", payment.cardType());
            map.put("card", payment.cardNumber());
            map.put("validity", payment.carValidity());
            map.put("cvv", payment.cardCvv());
            json.put("card", map);
        }
        return json;
    }

    private void notificationBoundaryService(DetailParking detailParking, RegisterParking registerParking, String clientEmail) {
        ezBoundaryServiceOpenFeign.createNotification(
                notificationObject(
                        detailParking,
                        registerParking,
                        clientEmail
                )
        );
    }

    private Map<String, Object> notificationObject(DetailParking detailParking, RegisterParking registerParking, String clientEmail) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Atenção!");
        map.put("message", "Fique esperto, sua ticket venceu!");
        map.put("parkingId", detailParking.id());
        map.put("email", clientEmail);
        map.put("duration", registerParking.duration());
        map.put("expirationTime", LocalDateTime.now().plusMinutes(registerParking.duration()));

        return map;
    }

}
