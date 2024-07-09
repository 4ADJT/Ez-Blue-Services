package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.domain.city.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    ParkingComponet parkingComponet;

    @Autowired
    CityServices cityServices;

    /**
     * Método principal da classe ParkingService, onde executará o registro do local onde o cliente estacionou.
     *
     * @param registerParking Objeto do formulário de cadastro do estacionamento.
     * @return DetailParking DetailRate Objeto contem todas as informações da tarifa.
     */
    public DetailParking register(RegisterParking registerParking) {

        var clientVehicleExists = parkingComponet.validateClientVehicle(registerParking.clientId(), registerParking.vehicleId());

        if (clientVehicleExists) {

            var rateValue = cityServices.getRateByCityId(registerParking.cityId());

            var parkingEntity = new ParkingEntity(registerParking,rateValue);
            parkingRepository.save(parkingEntity);
            return new DetailParking(parkingEntity);
        } else {
            throw new RuntimeException("Client Id or Vehicle Id Not Valid");
        }

    }

}
