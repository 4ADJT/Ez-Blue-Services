package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.openfeign.EzClientServiceOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    EzClientServiceOpenFeign ezClientServiceClient;

    /**
     * Método principal da classe ParkingService, onde executará o registro do local onde o cliente estacionou.
     *
     * @param registerParking Objeto do formulário de cadastro do estacionamento.
     * @return DetailParking DetailRate Objeto contem todas as informações da tarifa.
     */
    public DetailParking register(RegisterParking registerParking) {
        ParkingEntity parkingEntity = new ParkingEntity(registerParking);
        parkingRepository.save(parkingEntity);
        return new DetailParking(parkingEntity);
    }

    /**
     * Método de exemplo para se comunicar com outro micro serviço.
     *
     * @param clientId Identificador único do cliente.
     * @return String com os dados do cliente.
     */
    public String exampleMethod(UUID clientId) {
        return ezClientServiceClient.getClientById(clientId);
    }

}
