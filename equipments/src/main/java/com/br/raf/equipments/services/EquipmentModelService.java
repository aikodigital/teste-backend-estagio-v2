package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.EquipmentModel;
import com.br.raf.equipments.repositories.EquipmentModelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelService {
    private final EquipmentModelRepository equipmentModelRepository;

    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository) {
        this.equipmentModelRepository = equipmentModelRepository;
    }

    public List<EquipmentModel> findAll() {
        return equipmentModelRepository.findAll();
    }

    @Transactional
    public EquipmentModel save(EquipmentModel EquipmentModel){
        return equipmentModelRepository.save(EquipmentModel);
    }

    public Optional<EquipmentModel> findById(UUID id) {
        Optional<EquipmentModel> optionalEquipmentModel = equipmentModelRepository.findById(id);
        if(!optionalEquipmentModel.isPresent()){
            throw new RuntimeException("Id not found!");
        }
        return equipmentModelRepository.findById(id);
    }

    public void delete(EquipmentModel equipmentModel){
        equipmentModelRepository.delete(equipmentModel);
    }
}
