package com.aiko.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.domain.Equipment;
import com.aiko.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository repo;
	
	public Equipment find(UUID id) {
		Optional<Equipment> equipment = repo.findById(id);
		return equipment.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Equipment.class.getName(), null));
	}
	
	public List<Equipment> findAll() {
		return repo.findAll();
	}
	
	public Equipment save(Equipment equipment) {
		return repo.save(equipment);
	}
	
	public Equipment update(Equipment newEquipment) {
		Equipment equipment = find(newEquipment.getId());
		equipment.setName(newEquipment.getName());
		return repo.save(equipment);
	}
	
	public void delete(UUID id) {
		Equipment equipment = find(id);
		repo.delete(equipment);
	}
	
}
