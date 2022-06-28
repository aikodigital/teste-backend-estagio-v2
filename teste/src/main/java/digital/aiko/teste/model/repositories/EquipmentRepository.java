package digital.aiko.teste.model.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import digital.aiko.teste.model.entities.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, UUID>{

}
