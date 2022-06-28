package digital.aiko.teste.model.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.Equipment;
import digital.aiko.teste.model.repositories.EquipmentRepository;

@Service
public class EquipmentServices {

	private EquipmentRepository repository;

	public EquipmentServices(EquipmentRepository repository) {
		this.repository = repository;
	}
	
	public Equipment save(Equipment equipment) {
		
		return this.repository.save(equipment);
	}
	
	public Optional<Equipment> findById(String id) {
		return this.repository.findById(UUID.fromString(id));
	}
	
	public Iterable<Equipment> findAll() {
		 return this.repository.findAll();
	}

	public void deleteById(String id) {
		this.repository.deleteById(UUID.fromString(id));
	}
}
