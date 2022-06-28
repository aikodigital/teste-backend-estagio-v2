package com.equipments.apirest.services;

import com.equipments.apirest.models.Equipment;
import com.equipments.apirest.models.EquipmentPositionHistory;
import com.equipments.apirest.models.EquipmentPositionHistoryId;
import com.equipments.apirest.repositories.EquipmentPositionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentPositionHistoryService {

    @Autowired
    private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    private final EquipmentService equipmentService;

    public EquipmentPositionHistoryService(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository, EquipmentService equipmentService) {
        this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
        this.equipmentService = equipmentService;
    }

    public List<EquipmentPositionHistory> findALl(UUID equipmentId) {
        return equipmentPositionHistoryRepository.findAll(equipmentId);
    }

    public EquipmentPositionHistory create(EquipmentPositionHistory equipmentPositionHistory) {
        Equipment equipment = this.equipmentService.findById(equipmentPositionHistory.getEquipmentPositionHistoryId().getEquipment().getId());

        equipmentPositionHistory.getEquipmentPositionHistoryId().setEquipment(equipment);

        return this.equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    public EquipmentPositionHistory update(EquipmentPositionHistory equipmentPositionHistory) {
        return this.equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    public void deleteById(EquipmentPositionHistoryId id) {
        equipmentPositionHistoryRepository.deleteById(id);
    }
}
