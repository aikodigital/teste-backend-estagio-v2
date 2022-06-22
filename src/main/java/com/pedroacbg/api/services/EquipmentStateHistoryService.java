package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentState;
import com.pedroacbg.api.entities.EquipmentStateHistory;
import com.pedroacbg.api.pk.EquipmentStateHistoryPK;
import com.pedroacbg.api.repository.EquipmentStateHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EquipmentStateHistoryService {

    @Autowired
    private EquipmentStateHistoryRepository repository;

    public List<EquipmentStateHistory> findAll(){
        return repository.findAll();
    }

    public List<EquipmentStateHistory> findStateHistoryByEquipmentId(UUID equipmentId){
        return repository.findEquipmentStateHistory(equipmentId);
    }

    public EquipmentStateHistory insert(EquipmentStateHistory obj){
        Equipment equipment = obj.getId().getEquipment();
        LocalDateTime date = obj.getId().getDate();
        EquipmentState equipmentState = obj.getId().getEquipmentState();
        EquipmentStateHistoryPK id = new EquipmentStateHistoryPK(equipment, equipmentState, date);
        return repository.save(obj);
    }

    public EquipmentStateHistory update(List<EquipmentStateHistory> objs){
        EquipmentStateHistory find = objs.get(0);
        EquipmentStateHistory save = objs.get(1);
        repository.deleteById(find.getId());
        return repository.save(save);
    }

    public void deleteById(EquipmentStateHistory obj){
        repository.deleteById(obj.getId());
    }

    public EquipmentStateHistory findCurrentStateByEquipmentId(UUID equipmentId){
        return repository.findCurrentState(equipmentId).get(0);
    }

}
