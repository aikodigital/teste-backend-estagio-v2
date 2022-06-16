package com.aiko.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.domain.EquipmentState;
import com.aiko.repositories.EquipmentStateRepository;

@Service
public class EquipmentStateService {
	
	@Autowired
	private EquipmentStateRepository repo;
	
	public EquipmentState find(UUID id) {
		Optional<EquipmentState> equipmentState = repo.findById(id);
		return equipmentState.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  EquipmentState.class.getName(), null));
	}
	
	public List<EquipmentState> findAll() {
		return repo.findAll();
	}
	
	public EquipmentState save(EquipmentState equipmentState) {
		return repo.save(equipmentState);
	}
	
	public EquipmentState update(EquipmentState newEquipmentState) {
		EquipmentState equipmentState = find(newEquipmentState.getId());
		equipmentState.setName(newEquipmentState.getName());
		equipmentState.setColor(newEquipmentState.getColor());
		return repo.save(equipmentState);
	}
	
	public void delete(UUID id) {
		EquipmentState equipmentState = find(id);
		repo.delete(equipmentState);
	}
	
}
