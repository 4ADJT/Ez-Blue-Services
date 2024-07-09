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

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public ParkingEntity(RegisterParking registerParking) {
        this.clientId = registerParking.clientId();
        this.cityId = registerParking.cityId();
        this.startTime = registerParking.startTime();
        this.endTime = registerParking.endTime();
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

}
