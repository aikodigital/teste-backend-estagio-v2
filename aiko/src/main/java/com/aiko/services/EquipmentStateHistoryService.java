package com.aiko.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.domain.EquipmentStateHistory;
import com.aiko.repositories.EquipmentStateHistoryRepository;

@Service
public class EquipmentStateHistoryService {

	@Autowired
	private EquipmentStateHistoryRepository repo;

	public EquipmentStateHistory find(UUID id) {
		Optional<EquipmentStateHistory> equipmentStateHistory = repo.findById(id);
		return equipmentStateHistory.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EquipmentStateHistory.class.getName(), null));
	}

	public List<EquipmentStateHistory> findAll() {
		return repo.findAll();
	}

	public EquipmentStateHistory save(EquipmentStateHistory equipmentStateHistory) {
		return repo.save(equipmentStateHistory);
	}

	public EquipmentStateHistory update(EquipmentStateHistory newEquipmentStateHistory) {
		EquipmentStateHistory equipmentStateHistory = find(newEquipmentStateHistory.getEquipment().getId());
		equipmentStateHistory.setDate(newEquipmentStateHistory.getDate());
		return repo.save(equipmentStateHistory);
	}

	public void delete(UUID id) {
		EquipmentStateHistory equipmentStateHistory = find(id);
		repo.delete(equipmentStateHistory);
	}

	public List<EquipmentStateHistory> findAllState() {
		return repo.findAllState();
	}
	
}
