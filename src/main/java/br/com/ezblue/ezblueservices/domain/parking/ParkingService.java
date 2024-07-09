package br.com.ezblue.ezblueservices.domain.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
   private ParkingRepository parkingRepository;

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

}
