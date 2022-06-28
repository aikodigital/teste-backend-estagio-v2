package com.equipments.apirest.services;

import com.equipments.apirest.models.EquipmentModel;
import com.equipments.apirest.repositories.EquipmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentModelService {
    @Autowired
    private final EquipmentModelRepository equipmentModelRepository;

    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository) {
        this.equipmentModelRepository = equipmentModelRepository;
    }

    public List<EquipmentModel> findAll() {
        return equipmentModelRepository.findAll();
    }

    public EquipmentModel findById(UUID id) {
        EquipmentModel equipmentModelSave = this.equipmentModelRepository
                .findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return equipmentModelSave;
    }

    public EquipmentModel create(EquipmentModel equipmentModel) {
        return this.equipmentModelRepository.save(equipmentModel);
    }

    public EquipmentModel update(EquipmentModel equipmentModel) {
        return this.equipmentModelRepository.save(equipmentModel);
    }

    public void deleteById(UUID id) {
        equipmentModelRepository.deleteById(id);
    }


}
