package br.com.ezblue.ezblueservices.domain.rate;

import br.com.ezblue.ezblueservices.domain.city.CityServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RateServices {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private CityServices cityServices;

    /**
     * Registar uma tarifa a uma cidade específica.
     *
     * @param cityId       O Id da cidade para associar a tarifa.
     * @param registerRate Objeto do formulário de cadastro da tarifa.
     * @return DetailRate Objeto contem todas as informações da tarifa.
     */
    public DetailRate register(UUID cityId, RegisterRate registerRate) {
        var rateEntity = cityServices.findById(cityId).map(cityEntity ->
                new RateEntity(cityEntity, registerRate)
        ).orElseThrow(() -> new RuntimeException("City not found"));
        rateRepository.save(rateEntity);
        return new DetailRate(rateEntity);
    }

    /**
     * Detalhar uma tarifa específica de uma cidade específica.
     *
     * @param cityId O Id da cidade.
     * @param id     O Id da tarifa.
     * @return DetailRate Objeto contem todas as informações da tarifa com os dados simples da cidade.
     * @throws RuntimeException caso cidade ou tarifa não exista.
     */
    public DetailRate findCityRateById(UUID cityId, UUID id) {

        var cityEntity = cityServices.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));

        var rateEntity = rateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        if (!cityEntity.getId().equals(rateEntity.getCity().getId()))
            throw new RuntimeException("Rate does not belong to the city");

        return new DetailRate(rateEntity);
    }

    /**
     * Busca todas tarifas registradas.
     *
     * @param pageable Objeto com as informações de paginação.
     * @return Page<SimpleRate> Objeto retorna uma lista de todas as tarifas registradas com as informações basica.
     */
    public Page<SimpleRate> findAll(Pageable pageable) {
        return rateRepository.findAll(pageable).map(SimpleRate::new);
    }

    /**
     * Consulta uma tarifa pelo UUID
     *
     * @param id O Id da tarifa a ser consultada.
     * @return RateEntity Objeto de entidade da Tarifa.
     */
    public RateEntity findById(UUID id) {
        return rateRepository.findById(id).orElseThrow(() -> new RuntimeException("Rate not found"));
    }

    /**
     * Consulta uma tarifa pelo UUID
     *
     * @param id O Id da tarifa a ser consultada.
     * @return DetailRate Objeto contem todas as informações da tarifa com os dados simples da cidade.
     * @throws RuntimeException caso tarifa não exista.
     */
    public DetailRate findRateById(UUID id) {
        return rateRepository.findById(id).map(DetailRate::new)
                .orElseThrow(() -> new RuntimeException("Rate not found"));
    }

    /**
     * Atualizar a tarifa de uma cidade.
     *
     * @param cityId     Identificador único da cidade.
     * @param id         Identificador único da tarifa a ser atualizada.
     * @param updateRate
     * @return DetailRate Objeto retorna os dados completo da tarifa.
     * @throws RuntimeException Caso a cidade ou a tarifa não exista, ou caso a taria não pertença à cidade informada.
     */
    public DetailRate updateCityRateById(UUID cityId, UUID id, @Valid UpdateRate updateRate) {
        var cityEntity = cityServices.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));
        var rateEntity = rateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        if (rateEntity.getCity().getId() != cityEntity.getId())
            throw new RuntimeException("Rate does not belong to the city");

        rateEntity.updateData(updateRate);
        return new DetailRate(rateEntity);
    }
}
