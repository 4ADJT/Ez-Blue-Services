package br.com.ezblue.ezblueservices.domain.parking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingRepository extends JpaRepository<ParkingEntity, UUID> {
}
