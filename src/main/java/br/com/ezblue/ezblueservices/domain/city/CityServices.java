package br.com.ezblue.ezblueservices.domain.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CityServices {

    @Autowired
    private CityRepository cityRepository;

    /**
     * Registrar uma cidade.
     *
     * @param registerCity Objeto do formulário de cadastro da cidade.
     * @return DetailCity objeto contem todas as informações da cidade.
     */
    public DetailCity register(RegisterCity registerCity) {
        var cityEntity = new CityEntity(registerCity);
        cityRepository.save(cityEntity);
        return new DetailCity(cityEntity);
    }

    public Optional<CityEntity> findById(UUID cityId) {
        return cityRepository.findById(cityId);
    }
}
