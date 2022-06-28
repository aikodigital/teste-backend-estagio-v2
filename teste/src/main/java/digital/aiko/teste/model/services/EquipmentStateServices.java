package digital.aiko.teste.model.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.EquipmentState;
import digital.aiko.teste.model.repositories.EquipmentStateRepository;

@Service
public class EquipmentStateServices {

	private EquipmentStateRepository repository;

	public EquipmentStateServices(EquipmentStateRepository repository) {
		this.repository = repository;
	}

	public EquipmentState save(EquipmentState equipmentState) {
		return this.repository.save(equipmentState);
	}

	public Optional<EquipmentState> findById(String id) {
		return this.repository.findById(UUID.fromString(id));
	}

	public Iterable<EquipmentState> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(String id) {
		this.repository.deleteById(UUID.fromString(id));
	}

}
