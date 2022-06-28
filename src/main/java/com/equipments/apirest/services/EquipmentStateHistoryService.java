package com.equipments.apirest.services;

import com.equipments.apirest.models.EquipmentStateHistory;
import com.equipments.apirest.models.EquipmentStateHistoryId;
import com.equipments.apirest.repositories.EquipmentStateHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentStateHistoryService {

    @Autowired
    private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    public EquipmentStateHistoryService(EquipmentStateHistoryRepository equipmentStateHistoryRepository) {
        this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
    }

    public List<EquipmentStateHistory> findAll() {
        return equipmentStateHistoryRepository.findAll();
    }

    public EquipmentStateHistory findById(EquipmentStateHistoryId id) {
        return this.equipmentStateHistoryRepository
                .findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public EquipmentStateHistory create(EquipmentStateHistory equipmentStateHistory) {
        return this.equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    public EquipmentStateHistory update(EquipmentStateHistory equipmentStateHistory) {
        return this.equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    public void deleteById(EquipmentStateHistoryId id) {
        equipmentStateHistoryRepository.deleteById(id);
    }
}
