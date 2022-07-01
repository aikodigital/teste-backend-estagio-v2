package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.Equipment;
import com.br.raf.equipments.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Transactional
    public Equipment save(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    /*public Equipment createEquipment(Equipment equipment){
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipment.getId());
        if(optionalEquipment.isPresent()){
            throw new RuntimeException();
        }
        return equipment = equipmentRepository.save(equipment);
    }*/

    public Optional<Equipment> findById(UUID id) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(id);
        if(!optionalEquipment.isPresent()){
            throw new RuntimeException("Id not found!");
        }
        return equipmentRepository.findById(id);
    }

    public void delete(Equipment equipment){
        equipmentRepository.delete(equipment);
    }
}
