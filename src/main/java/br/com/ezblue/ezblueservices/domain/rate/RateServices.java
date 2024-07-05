package br.com.ezblue.ezblueservices.domain.rate;

import br.com.ezblue.ezblueservices.domain.city.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RateServices {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private CityServices cityServices;

    public DetailRate register(UUID cityId, RegisterRate registerRate) {
        var rateEntity = cityServices.findById(cityId).map(cityEntity ->
                new RateEntity(cityEntity, registerRate)
        ).orElseThrow(() -> new RuntimeException("City not found"));
        return new DetailRate(rateEntity);
    }
}
