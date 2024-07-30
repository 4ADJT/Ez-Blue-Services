package br.com.ezblue.ezblueservices.domain.rate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RateRepository extends JpaRepository<RateEntity, UUID> {
}
