package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistory;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistoryId;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentStateHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateHistoryRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateRepository;

@Service
public class EquipmentStateHistoryServiceImpl implements EquipmentStateHistoryService {

	private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	private final EquipmentStateRepository equipmentStateRepository;
	private final EquipmentRepository equipmentRepository;
	
	public EquipmentStateHistoryServiceImpl(EquipmentStateHistoryRepository equipmentStateHistoryRepository,
			EquipmentStateRepository equipmentStateRepository, EquipmentRepository equipmentRepository) {
		this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
		this.equipmentStateRepository = equipmentStateRepository;
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public EquipmentStateHistory create(EquipmentStateHistory object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentStateHistory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentStateHistory findById(EquipmentStateHistoryId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentStateHistory update(EquipmentStateHistoryId id, EquipmentStateHistory object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EquipmentStateHistoryId id) {
		// TODO Auto-generated method stub
	}

}
