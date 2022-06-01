package com.aiko.testebackendestagiov2.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.repositories.EquipmentRepository;
import com.aiko.testebackendestagiov2.services.interfaces.StdCrudService;

import org.springframework.stereotype.Service;

@Service
public class EquipmentService implements StdCrudService<Equipment, UUID> {
 
    private EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment findById(UUID id) {
        try{
            return equipmentRepository.findById(id).get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public Equipment save(Equipment obj) {
        return equipmentRepository.save(obj);
    }

    @Override
    public Equipment update(UUID id, Equipment obj) {
        Equipment equipmentToUpdate = equipmentRepository.findById(id).get();
        equipmentToUpdate.setName(obj.getName());
        return equipmentRepository.save(equipmentToUpdate);
    }

    @Override
    public void deleteById(UUID id) {
        equipmentRepository.deleteById(id);
    }

}