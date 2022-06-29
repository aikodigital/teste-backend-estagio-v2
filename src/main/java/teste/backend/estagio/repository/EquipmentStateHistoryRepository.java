package teste.backend.estagio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import teste.backend.estagio.entities.EquipmentStateHistory;
import teste.backend.estagio.entities.pk.EquipmentStateHistoryPk;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryPk>{

	@Query(value = "SELECT statehistory FROM EquipmentStateHistory AS state JOIN state.id AS pk JOIN pk.equipment AS s WHERE s.id = 1? ORDER BY pk.date DESC")
	public List<EquipmentStateHistory> currentEquipmentState(UUID id_equipment);
}
