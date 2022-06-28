package com.equipments.apirest.services;

import com.equipments.apirest.models.Equipment;
import com.equipments.apirest.repositories.EquipmentRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentModelService equipmentModelService;


    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentModelService equipmentModelService) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentModelService = equipmentModelService;
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment findById(UUID equipmentId) {
        Equipment equipmentSave = this.equipmentRepository
                .findById(equipmentId)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return equipmentSave;
    }

    public Equipment create(Equipment equipment) {
        final var equipmentModel = equipmentModelService
                .findById(equipment.getEquipmentModel().getId());
        equipment.setEquipmentModel(equipmentModel);
        return this.equipmentRepository.save(equipment);
    }

    public Equipment update(Equipment equipment) {
        final var equipmentModel = equipmentModelService
                .findById(equipment.getEquipmentModel().getId());
        equipment.setEquipmentModel(equipmentModel);
        return this.equipmentRepository.save(equipment);
    }

    public void deleteById(UUID equipmentId) {
        equipmentRepository.deleteById(equipmentId);

    }
}
