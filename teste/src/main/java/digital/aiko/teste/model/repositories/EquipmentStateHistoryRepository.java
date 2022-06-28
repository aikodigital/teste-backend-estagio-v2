package digital.aiko.teste.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import digital.aiko.teste.model.entities.EquipmentStateHistory;
import digital.aiko.teste.model.entities.ModelStateHistoryId;

public interface EquipmentStateHistoryRepository extends CrudRepository<EquipmentStateHistory, ModelStateHistoryId>{

	@Query("SELECT p FROM EquipmentStateHistory p WHERE p.id = :id")
	public Iterable<EquipmentStateHistory> searchByIdLike(@Param("id") ModelStateHistoryId id, @Param("id") ModelStateHistoryId id2);
}
	