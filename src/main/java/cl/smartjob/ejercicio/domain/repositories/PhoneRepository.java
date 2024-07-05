package cl.smartjob.ejercicio.domain.repositories;

import cl.smartjob.ejercicio.domain.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
    List<Phone> findAllByUserId(UUID userId);
}
