package digital.aiko.teste.model.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.EquipmentModel;
import digital.aiko.teste.model.repositories.EquipmentModelRepository;

@Service
public class EquipmentModelServices {

	private EquipmentModelRepository repository;

	public EquipmentModelServices(EquipmentModelRepository repository) {
		this.repository = repository;
	}

	public EquipmentModel save(EquipmentModel equipmentModel) {
		return this.repository.save(equipmentModel);
	}

	public Optional<EquipmentModel> findById(String id) {
		return this.repository.findById(UUID.fromString(id));
	}

	public Iterable<EquipmentModel> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(String id) {
		this.repository.deleteById(UUID.fromString(id));
	}

}
