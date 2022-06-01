package com.aiko.testebackendestagiov2.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentModel;
import com.aiko.testebackendestagiov2.repositories.EquipmentModelRepository;
import com.aiko.testebackendestagiov2.services.interfaces.StdCrudService;

import org.springframework.stereotype.Service;

@Service
public class EquipmentModelService implements StdCrudService<EquipmentModel, UUID> {

    private EquipmentModelRepository equipmentModelRepository;

    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository){
        this.equipmentModelRepository = equipmentModelRepository;
    }

    @Override
    public List<EquipmentModel> findAll() {
        return equipmentModelRepository.findAll();
    }

    @Override
    public EquipmentModel findById(UUID id) {
        try{
            return equipmentModelRepository.findById(id).get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public EquipmentModel save(EquipmentModel obj) {
        return equipmentModelRepository.save(obj);
    }

    @Override
    public EquipmentModel update(UUID id, EquipmentModel obj) {
        EquipmentModel modelToUpdate = equipmentModelRepository.findById(id).get();
        modelToUpdate.setName(obj.getName());
        return equipmentModelRepository.save(modelToUpdate);
    }

    @Override
    public void deleteById(UUID id) {
        equipmentModelRepository.deleteById(id);
    }

}