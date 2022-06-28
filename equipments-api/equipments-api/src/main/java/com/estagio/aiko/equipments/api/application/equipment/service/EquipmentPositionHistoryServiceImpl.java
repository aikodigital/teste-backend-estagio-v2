package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistory;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistoryId;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentPositionHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentPositionHistoryRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentRepository;


@Service
public class EquipmentPositionHistoryServiceImpl implements EquipmentPositionHistoryService {

    private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
    private final EquipmentRepository equipmentRepository;
	
	public EquipmentPositionHistoryServiceImpl(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository,
			EquipmentRepository equipmentRepository) {
		this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public EquipmentPositionHistory create(EquipmentPositionHistory object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentPositionHistory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentPositionHistory findById(EquipmentPositionHistoryId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentPositionHistory update(EquipmentPositionHistoryId id, EquipmentPositionHistory object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EquipmentPositionHistoryId id) {
		EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
	}

}
