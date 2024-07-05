package br.com.ezblue.ezblueservices.domain.rate;

import br.com.ezblue.ezblueservices.domain.city.CityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
    private String currency;
    private double rateValue;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public RateEntity(CityEntity cityEntity, RegisterRate registerRate) {
        this.city = cityEntity;
        this.currency = registerRate.currency();
        this.rateValue = registerRate.rateValue();
        this.createdDate = LocalDateTime.now();
    }
}
