package teste.backend.estagio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.backend.estagio.entities.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID>{
	
}
