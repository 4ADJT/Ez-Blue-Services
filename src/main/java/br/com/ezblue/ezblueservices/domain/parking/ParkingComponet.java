package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.openfeign.EzClientServiceOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@Component
public class ParkingComponet {

    @Autowired
    EzClientServiceOpenFeign ezClientServiceOpenFeign;

    /**
     * Método de exemplo para se comunicar com outro micro serviço.
     *
     * @param clientId Identificador único do cliente.
     * @return String com os dados do cliente.
     */
    public Object exampleMethod(UUID clientId) {
        return ezClientServiceOpenFeign.getClientById(clientId);
    }

    public boolean validateClientVehicle(UUID clientId, UUID vehicleId) {
        var clientEntity = ezClientServiceOpenFeign.getClientById(clientId);

        boolean clientExists = clientEntity.get("id").toString()
                .equals(clientId.toString());

        var vehicleList = (ArrayList<Map<String, Object>>) clientEntity.get("vehicle");

        boolean veicileExists = vehicleList.stream()
                .anyMatch(vehicle -> vehicle.get("id").toString()
                        .equals(vehicleId.toString())
                );

        return clientExists && veicileExists;
    }
}
