package com.aiko.testebackendestagiov2.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.models.EquipmentState;
import com.aiko.testebackendestagiov2.models.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.models.pk.EquipmentStateHistoryPK;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateHistoryRepository;

import org.springframework.stereotype.Service;

@Service
public class EquipmentStateHistoryService {

    private EquipmentStateHistoryRepository stateHistoryRepository;

    public EquipmentStateHistoryService(EquipmentStateHistoryRepository stateHistoryRepository) {
        this.stateHistoryRepository = stateHistoryRepository;
    }

    public List<EquipmentStateHistory> findAll() {
        return stateHistoryRepository.findAll();
    }

    public List<EquipmentStateHistory> findStateHistoriesByEquipmentId(UUID equipmentId) {
        return stateHistoryRepository.findEquipmentStateHistory(equipmentId);
    }

    public EquipmentStateHistory save(EquipmentStateHistory obj) {
        Equipment equipment = obj.getEquipment();
        LocalDateTime date = obj.getDate();
        EquipmentState equipmentState = obj.getEquipmentState();
        EquipmentStateHistoryPK id = new EquipmentStateHistoryPK(equipment, equipmentState, date);
        boolean stateHistoryCheck = stateHistoryRepository.findById(id).isPresent();
        if(stateHistoryCheck){
            return null;
        }else{
            return stateHistoryRepository.save(obj);
        }
    }

    public EquipmentStateHistory update(List<EquipmentStateHistory> objs) {
        EquipmentStateHistory objToFind = objs.get(0);
        EquipmentStateHistory objToSave = objs.get(1);
        stateHistoryRepository.deleteById(objToFind.getId());
        return stateHistoryRepository.save(objToSave);
    }

    public void deleteById(EquipmentStateHistory obj) {
        stateHistoryRepository.deleteById(obj.getId());
    }

    public EquipmentStateHistory findCurrentState(UUID equipmentId){
        return stateHistoryRepository.findCurrentState(equipmentId).get(0);
    }
    
}