package digital.aiko.teste.model.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import digital.aiko.teste.model.entities.EquipmentPositionHistory;

public interface EquipmentPositionHistoryRepository extends CrudRepository<EquipmentPositionHistory, UUID> {

}
