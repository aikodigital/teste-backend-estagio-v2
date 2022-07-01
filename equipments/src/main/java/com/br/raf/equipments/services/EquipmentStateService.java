package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.EquipmentState;
import com.br.raf.equipments.repositories.EquipmentStateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentStateService {
    private final EquipmentStateRepository equipmentStateRepository;

    public EquipmentStateService(EquipmentStateRepository equipmentStateRepository) {
        this.equipmentStateRepository = equipmentStateRepository;
    }

    public List<EquipmentState> findAll(){
        return equipmentStateRepository.findAll();
    }

    @Transactional
    public EquipmentState save(EquipmentState equipmentState){
        return equipmentStateRepository.save(equipmentState);
    }

    public Optional<EquipmentState> findById(UUID id) {
        Optional<EquipmentState> optionalEquipmentState = equipmentStateRepository.findById(id);
        if(!optionalEquipmentState.isPresent()){
            throw new RuntimeException("Id not found!");
        }
        return equipmentStateRepository.findById(id);
    }

    public void delete(EquipmentState equipmentState){
        equipmentStateRepository.delete(equipmentState);
    }
}
