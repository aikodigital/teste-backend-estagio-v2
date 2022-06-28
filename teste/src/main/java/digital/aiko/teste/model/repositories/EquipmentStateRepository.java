package digital.aiko.teste.model.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import digital.aiko.teste.model.entities.EquipmentState;

public interface EquipmentStateRepository extends CrudRepository<EquipmentState, UUID>{


}
