package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.domain.payment.RegisterPayment;
import br.com.ezblue.ezblueservices.openfeign.EzBoundaryServiceOpenFeign;
import br.com.ezblue.ezblueservices.openfeign.EzClientServiceOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Map<String, Object> paymentBoundaryService(UUID uuid, RegisterPayment payment, Double rateValue) {
        return ezBoundaryServiceOpenFeign.createPayment(paymentObject(uuid, payment, rateValue));
    }

    private Map<String, Object> paymentObject(UUID uuid, RegisterPayment payment, Double rateValue) {
        var clientEntity = getClientById(uuid);
        String clientID = clientEntity.get("id").toString();
        Map<String, Object> json = new HashMap<>();

        json.put("customerID", clientID);
        json.put("type", payment.paymentType());
        json.put("value", rateValue);

        if (payment.paymentType().equals("PIX")) {
            Map<String, Object> map = new HashMap<>();
            json.put("pix", map.put("key", payment.key()));
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


}
