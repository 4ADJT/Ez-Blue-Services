package br.com.ezblue.ezblueservices.domain.parking;

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
@Entity(name = "parking")
@Table(name = "parking")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID clientId;
    private UUID vehicleId;
    private UUID cityId;
    private long duration;
    private double ticketValue;
    private LocalDateTime createdDate;

    public ParkingEntity(RegisterParking registerParking, Double rateValue) {
        this.clientId = registerParking.clientId();
        this.cityId = registerParking.cityId();
        this.duration = registerParking.duration();
        this.ticketValue = rateValue * duration;
        this.createdDate = LocalDateTime.now();
    }

}
