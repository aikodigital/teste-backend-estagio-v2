package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentPositionHistory;
import com.pedroacbg.api.pk.EquipmentPositionHistoryPK;
import com.pedroacbg.api.repository.EquipmentPositionHistoryRepository;
import com.pedroacbg.api.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EquipmentPositionHistoryService {

    @Autowired
    private EquipmentPositionHistoryRepository repository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<EquipmentPositionHistory> findAll(){
        return repository.findAll();
    }

    public List<EquipmentPositionHistory> findByEquipmentId(UUID id){
        Equipment equipment = equipmentRepository.findById(id).get();
        return repository.findEquipmentPositionHistoryById(equipment.getId());
    }

    public EquipmentPositionHistory insert(EquipmentPositionHistory obj){
        Equipment equipment = obj.getId().getEquipment();
        LocalDateTime date = obj.getId().getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        return repository.save(obj);
    }

    public EquipmentPositionHistory update(UUID equipmentId, EquipmentPositionHistory obj){
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        LocalDateTime date = obj.getId().getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        EquipmentPositionHistory update = repository.findById(id).get();
        update.setLat(obj.getLat());
        update.setLon(obj.getLon());
        return repository.save(update);
    }

    public void deleteById(UUID equipmentId, EquipmentPositionHistory obj){
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        LocalDateTime date = obj.getId().getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        repository.deleteById(id);
    }

    public EquipmentPositionHistory findEquipmentCurrentPosition(UUID equipmentId){
        return repository.findCurrentEquipmentPosition(equipmentId).get(0);
    }

}
