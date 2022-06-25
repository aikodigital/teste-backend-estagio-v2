package com.aiko.testebackendestagiov2.services.Impl;

import com.aiko.testebackendestagiov2.dtos.EquipmentPositionHistoryRequest;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.repositories.EquipmentPositionHistoryRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentPositionHistoryCrudService implements ICrudService<EquipmentPositionHistory, EquipmentPositionHistoryRequest> {

    private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    private final EquipmentCrudService equipmentCrudService;


    @Override
    public List<EquipmentPositionHistory> getAll() {
        return equipmentPositionHistoryRepository.findAll();
    }

    @Override
    public EquipmentPositionHistory getById(UUID id) {
        return equipmentPositionHistoryRepository.findById(id).orElseThrow();
    }

    @Override
    public EquipmentPositionHistory create(EquipmentPositionHistoryRequest request) {
        Equipment equipment = equipmentCrudService.getById(request.getEquipmentId());
        EquipmentPositionHistory equipmentPositionHistory = new EquipmentPositionHistory();
        equipmentPositionHistory.setLat(request.getLat());
        equipmentPositionHistory.setLon(request.getLon());
        equipmentPositionHistory.setEquipment(equipment);
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    @Override
    public EquipmentPositionHistory update(UUID id, EquipmentPositionHistoryRequest request) {
        Equipment equipment = equipmentCrudService.getById(request.getEquipmentId());
        EquipmentPositionHistory equipmentPositionHistory = this.getById(id);
        equipmentPositionHistory.setLat(request.getLat());
        equipmentPositionHistory.setLon(request.getLon());
        equipmentPositionHistory.setEquipment(equipment);
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    @Override
    public void delete(UUID id) {
        equipmentPositionHistoryRepository.deleteById(id);
    }
}
