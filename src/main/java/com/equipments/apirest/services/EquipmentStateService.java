package com.equipments.apirest.services;

import com.equipments.apirest.models.EquipmentState;
import com.equipments.apirest.repositories.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentStateService {

    @Autowired
    private final EquipmentStateRepository equipmentStateRepository;

    public EquipmentStateService(EquipmentStateRepository equipmentStateRepository) {
        this.equipmentStateRepository = equipmentStateRepository;
    }

    public List<EquipmentState> findAll() {
        return equipmentStateRepository.findAll();
    }

    public EquipmentState findById(UUID equipmentStateId) {
        EquipmentState equipmentStateSave = this.equipmentStateRepository
                .findById(equipmentStateId)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return equipmentStateSave;
    }

    public EquipmentState create(EquipmentState equipmentState) {
        return this.equipmentStateRepository.save(equipmentState);
    }

    public EquipmentState update(EquipmentState equipmentState) {
        return this.equipmentStateRepository.save(equipmentState);
    }

    public void deleteById(UUID id) {
        equipmentStateRepository.deleteById(id);
    }
}
