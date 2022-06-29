package teste.backend.estagio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import teste.backend.estagio.entities.EquipmentPositionHistory;
import teste.backend.estagio.entities.pk.EquipmentPositionHistoryPk;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryPk>{

	@Query(value = "SELECT equipment FROM EquipmentPositionHistory AS equi JOIN equi.id AS pk JOIN pk.equipment as e WHERE e.id = 1?")
	List<EquipmentPositionHistory> currentEquipmentPosition(UUID id_equipment);
	
}
