package com.aiko.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.domain.EquipmentPositionHistory;
import com.aiko.repositories.EquipmentPositionHistoryRepository;


@Service
public class EquipmentPositionHistoryService {

	@Autowired
	private EquipmentPositionHistoryRepository repo;
	
	public List<EquipmentPositionHistory> findPosition() {
		return repo.findPosition();
	}
	
	public EquipmentPositionHistory find(UUID id) {
		Optional<EquipmentPositionHistory> EquipmentPositionHistory = repo.findById(id);
		return EquipmentPositionHistory.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  EquipmentPositionHistory.class.getName(), null));
	}
	
	public List<EquipmentPositionHistory> findAll() {
		return repo.findAll();
	}
	
	public EquipmentPositionHistory save(EquipmentPositionHistory EquipmentPositionHistory) {
		return repo.save(EquipmentPositionHistory);
	}
	
	public EquipmentPositionHistory update(EquipmentPositionHistory newEquipmentPositionHistory) {
		EquipmentPositionHistory equipmentPositionHistory = find(newEquipmentPositionHistory.getId());
		equipmentPositionHistory.setDate(newEquipmentPositionHistory.getDate());
		equipmentPositionHistory.setLat(newEquipmentPositionHistory.getLat());
		equipmentPositionHistory.setLon(newEquipmentPositionHistory.getLon());
		return repo.save(equipmentPositionHistory);
	}
	
	public void delete(UUID id) {
		EquipmentPositionHistory EquipmentPositionHistory = find(id);
		repo.delete(EquipmentPositionHistory);
	}
}
