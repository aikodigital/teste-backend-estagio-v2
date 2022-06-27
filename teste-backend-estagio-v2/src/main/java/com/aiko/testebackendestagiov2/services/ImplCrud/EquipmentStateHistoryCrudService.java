package com.aiko.testebackendestagiov2.services.ImplCrud;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentStateHistoryRequest;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.exceptions.NotFoundError;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateHistoryRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentStateHistoryCrudService implements ICrudService<EquipmentStateHistory, EquipmentStateHistoryRequest> {

    private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    private final EquipmentCrudService equipmentCrudService;

    private final EquipmentStateCrudService equipmentStateCrudService;

    @Override
    public List<EquipmentStateHistory> getAll() {
        return equipmentStateHistoryRepository.findAll();
    }

    @Override
    public EquipmentStateHistory getById(UUID id) {
        return equipmentStateHistoryRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundError("Don't exist Equipment State History with this id " + id));
    }

    @Override
    public EquipmentStateHistory create(EquipmentStateHistoryRequest request) {
        Equipment equipment = equipmentCrudService.getById(request.getEquipmentId());
        EquipmentState equipmentState = equipmentStateCrudService.getById(request.getEquipmentStateId());
        EquipmentStateHistory equipmentStateHistory = new EquipmentStateHistory();
        equipmentStateHistory.setDate(new Date());
        equipmentStateHistory.setEquipment(equipment);
        equipmentStateHistory.setEquipmentState(equipmentState);
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    @Override
    public EquipmentStateHistory update(UUID id, EquipmentStateHistoryRequest request) {
        Equipment equipment = equipmentCrudService.getById(request.getEquipmentId());
        EquipmentState equipmentState = equipmentStateCrudService.getById(request.getEquipmentStateId());
        EquipmentStateHistory equipmentStateHistory = this.getById(id);
        equipmentStateHistory.setDate(new Date());
        equipmentStateHistory.setEquipment(equipment);
        equipmentStateHistory.setEquipmentState(equipmentState);
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    @Override
    public void delete(UUID id) {
        equipmentStateHistoryRepository.deleteById(id);
    }
}
