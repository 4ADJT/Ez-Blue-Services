package br.com.ezblue.ezblueservices.domain.rate;

import br.com.ezblue.ezblueservices.domain.city.CityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "rate")
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    private String currency;
    private double rateValue;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    /**
     * Construtor que cria uma tarifa para a cidade.
     *
     * @param cityEntity   Objeto de entidade da cidade.
     * @param registerRate Formulário de cadastro da tarifa.
     */
    public RateEntity(CityEntity cityEntity, RegisterRate registerRate) {
        this.city = cityEntity;
        this.currency = registerRate.currency();
        this.rateValue = registerRate.rateValue();
        this.createdDate = LocalDateTime.now();
    }

    /**
     * Método para atualização dos dados da tarifa.
     *
     * @param updateRate Formulário de atualização da tarifa.
     */
    public void updateData(UpdateRate updateRate) {
        if (!Objects.equals(updateRate.currency(), this.currency))
            this.currency = updateRate.currency();
        if (updateRate.rateValue() != this.rateValue)
            this.rateValue = updateRate.rateValue();
    }
}
