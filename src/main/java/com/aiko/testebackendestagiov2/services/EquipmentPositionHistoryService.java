package com.aiko.testebackendestagiov2.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.models.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.models.pk.EquipmentPositionHistoryPK;
import com.aiko.testebackendestagiov2.repositories.EquipmentPositionHistoryRepository;
import com.aiko.testebackendestagiov2.repositories.EquipmentRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EquipmentPositionHistoryService {

    private EquipmentPositionHistoryRepository positionHistoryRepository;
    private EquipmentRepository equipmentRepository;

    public EquipmentPositionHistoryService(EquipmentPositionHistoryRepository positionHistoryRepository,
            EquipmentRepository equipmentRepository) {
        this.positionHistoryRepository = positionHistoryRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentPositionHistory> findAll() {
        return positionHistoryRepository.findAll();
    }

    public List<EquipmentPositionHistory> findPositionHistoriesByEquipmentId(UUID equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        return positionHistoryRepository.findEquipmentPositionHistory(equipment.getId());
    }

    public EquipmentPositionHistory save(EquipmentPositionHistory obj) {
        Equipment equipment = obj.getEquipment();
        LocalDateTime date = obj.getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        boolean foundHistory = positionHistoryRepository.findById(id).isPresent();
        if(foundHistory){
            return null;
        }else{
            return positionHistoryRepository.save(obj);
        }
    }

    public EquipmentPositionHistory update(UUID equipmentId, EquipmentPositionHistory obj) {
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        LocalDateTime date = obj.getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        try{
            EquipmentPositionHistory historyToUpdate = positionHistoryRepository.findById(id).get();
            historyToUpdate.setLat(obj.getLat());
            historyToUpdate.setLon(obj.getLon());
            return positionHistoryRepository.save(historyToUpdate);
        }catch(NoSuchElementException | DataIntegrityViolationException e){
            return null;
        }
    }

    public void deleteById(UUID equipmentId, EquipmentPositionHistory obj) {
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        LocalDateTime date = obj.getDate();
        EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK(equipment, date);
        positionHistoryRepository.deleteById(id);
    }

    public EquipmentPositionHistory findEquipmentCurrentPosition(UUID equipmentId){
        return positionHistoryRepository.findCurrentEquipmentPosition(equipmentId).get(0);
    }
    
}