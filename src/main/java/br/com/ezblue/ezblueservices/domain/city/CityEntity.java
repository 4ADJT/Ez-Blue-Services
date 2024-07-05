package br.com.ezblue.ezblueservices.domain.city;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
    private LocalDateTime created_date;
    private LocalDateTime last_modified_date;

    public CityEntity(RegisterCity registerCity) {
        this.city = registerCity.city();
        this.state = registerCity.state();
        this.country = registerCity.country();
        this.created_date = LocalDateTime.now();
    }
}
