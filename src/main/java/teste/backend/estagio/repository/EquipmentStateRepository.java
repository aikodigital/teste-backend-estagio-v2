package teste.backend.estagio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.backend.estagio.entities.EquipmentState;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID>{

}
