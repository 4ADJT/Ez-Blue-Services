package br.com.ezblue.ezblueservices.domain.city;

import br.com.ezblue.ezblueservices.domain.rate.RateEntity;
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
@Entity(name = "city")
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String city;
    private String state;
    private String country;

    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
    private RateEntity rate;

    private LocalDateTime created_date;
    private LocalDateTime last_modified_date;

    /**
     * Construtor que cria uma nova cidade a partir de um objeto de registro de cidade.
     *
     * @param registerCity o objeto {@code RegisterCity} com os dados da cidade.
     */
    public CityEntity(RegisterCity registerCity) {
        this.city = registerCity.city();
        this.state = registerCity.state();
        this.country = registerCity.country();
        this.created_date = LocalDateTime.now();
    }

    /**
     * Método de atualização dos dados da cidade.
     *
     * @param updateCity objeto {@code UpdateCity} com os dados do formulário de atualização da cidade.
     */
    public void updateData(UpdateCity updateCity) {
        if (updateCity.city() != null)
            this.city = updateCity.city();
        if (updateCity.state() != null)
            this.state = updateCity.state();
        if (updateCity.country() != null)
            this.country = updateCity.country();
    }
}
