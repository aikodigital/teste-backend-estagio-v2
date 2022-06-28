package digital.aiko.teste.model.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.EquipmentPositionHistory;
import digital.aiko.teste.model.repositories.EquipmentPositionHistoryRepository;

@Service
public class EquipmentPositionHistoryServices {

	private EquipmentPositionHistoryRepository repository;

	public EquipmentPositionHistoryServices(EquipmentPositionHistoryRepository repository) {
		this.repository = repository;
	}
	
	public EquipmentPositionHistory save(EquipmentPositionHistory equipmentPositionHistory) {
		return this.repository.save(equipmentPositionHistory);
	}
	
	public Optional<EquipmentPositionHistory> findById(String id) {
		return this.repository.findById(UUID.fromString(id));
	}

	public Iterable<EquipmentPositionHistory> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(String id) {
		this.repository.deleteById(UUID.fromString(id));
	}

}
