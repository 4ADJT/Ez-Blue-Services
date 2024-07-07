package br.com.ezblue.ezblueservices.domain.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * Consultar uma cidade pelo UUID.
     *
     * @param cityId O Id da cidade a ser consultada.
     * @return Optional<CityEntity> objeto contem a entidade da cidade.
     */
    public Optional<CityEntity> findById(UUID cityId) {
        return cityRepository.findById(cityId);
    }

    /**
     * Converte um objeto do tipo Optional<CityEntity> em um objeto DetailCity
     *
     * @param optionalCityEntity objeto Optional<CityEntity> para ser convertido
     * @return DetailCity objeto já convertido.
     * @throws RuntimeException caso cidade não exista
     */
    public DetailCity ConvertToDetailCity(Optional<CityEntity> optionalCityEntity) {
        return optionalCityEntity.map(DetailCity::new)
                .orElseThrow(() -> new RuntimeException("Error: City Not Found"));
    }

    /**
     * Buscar todos os registos.
     *
     * @param pageable objeto com as informações de paginação
     * @return Page<SimpleCity> objeto retorna uma lista de todas as cidades com as informações básicas.
     */
    public Page<SimpleCity> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable).map(SimpleCity::new);
    }

    /**
     * Atualizar dados da cidade
     *
     * @param id         Identificador único da cidade.
     * @param updateCity Objeto {@code UpdateCity} com os dados de atualização da cidade.
     * @return DetailCity Objeto com todos os detalhados da cidade.
     * @throws RuntimeException caso cidade não exista
     */
    public DetailCity updateCityById(UUID id, UpdateCity updateCity) {
        return cityRepository.findById(id).map(cityEntity -> {
            cityEntity.updateData(updateCity);
            return new DetailCity(cityEntity);
        }).orElseThrow(() -> new RuntimeException("Error: City Not Found"));
    }

}
