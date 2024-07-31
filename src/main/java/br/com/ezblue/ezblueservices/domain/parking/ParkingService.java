package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.domain.city.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    ParkingComponent parkingComponent;

    @Autowired
    CityServices cityServices;

    /**
     * Método principal da classe ParkingService, onde executará o registro do local onde o cliente estacionou.
     *
     * @param registerParking Objeto do formulário de cadastro do estacionamento.
     * @return DetailParking DetailRate Objeto contem todas as informações da tarifa.
     */
    public Map<String, Object> register(RegisterParking registerParking) {

        var clientVehicleExists = parkingComponent.validateClientVehicle(registerParking.clientId(), registerParking.vehicleId());

        if (clientVehicleExists) {

            if (!registerParking.payment().paymentType().equals("PIX") && !registerParking.payment().paymentType().equals("CARD"))
                throw new RuntimeException("Payment type invalid");

            var rateValue = cityServices.getRateByCityId(registerParking.cityId());

            var parkingEntity = new ParkingEntity(registerParking, rateValue);
            parkingRepository.save(parkingEntity);

            return parkingComponent.boundaryService(new DetailParking(parkingEntity), registerParking, rateValue);

        } else {
            throw new RuntimeException("Client Id or Vehicle Id Not Valid");
        }

    }

    /**
     * Método utilizado para retornar todas as instancias do objeto ParkingEntity na forma de DetailParking.
     *
     * @return List<DetailParking> DetailParking Objeto contem todas as informações do estacionamento.
     */
    public List<DetailParking> findAll() {
        List<ParkingEntity> parkingEntities = parkingRepository.findAll();
        return parkingEntities.stream()
                .map(DetailParking::new)
                .collect(Collectors.toList());
    }

    /**
     * Método utilizado para retornar todas as instancias do objeto ParkingEntity na forma de DetailParking que pertencem ao @ClientId.
     *
     * @param clientId - Id do cliente em que deseja retornar o estórico de estacionamento.
     * @return List<DetailParking> DetailParking Objeto contem todas as informações do estacionamento.
     */
    public List<DetailParking> findAllByClientId(UUID clientId) {
        List<ParkingEntity> parkingEntities = parkingRepository.findAllByClientId(clientId);
        return parkingEntities.stream()
                .map(DetailParking::new)
                .collect(Collectors.toList());
    }

}
