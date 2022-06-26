package com.aiko.testebackendestagiov2.services.Impl;

import com.aiko.testebackendestagiov2.dtos.EquipmentModelStateHourlyEarningsRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import com.aiko.testebackendestagiov2.repositories.EquipmentModelStateHourlyEarningsRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentModelStateHourlyEarningsCrudService implements
        ICrudService<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsRequest> {

   private final EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

   private final EquipmentModelCrudService equipmentModelCrudService;

   private final EquipmentStateCrudService equipmentStateCrudService;

    @Override
    public List<EquipmentModelStateHourlyEarnings> getAll() {
        return equipmentModelStateHourlyEarningsRepository.findAll();
    }

    @Override
    public EquipmentModelStateHourlyEarnings getById(UUID id) {
        return equipmentModelStateHourlyEarningsRepository.findById(id).orElseThrow();
    }

    @Override
    public EquipmentModelStateHourlyEarnings create(EquipmentModelStateHourlyEarningsRequest request) {
        EquipmentState equipmentState = equipmentStateCrudService.getById(request.getEquipmentStateId());
        EquipmentModel equipmentModel = equipmentModelCrudService.getById(request.getEquipmentModelId());
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = new EquipmentModelStateHourlyEarnings();
        equipmentModelStateHourlyEarnings.setEquipmentModel(equipmentModel);
        equipmentModelStateHourlyEarnings.setEquipmentState(equipmentState);
        equipmentModelStateHourlyEarnings.setValue(request.getValue());
        return equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
    }

    @Override
    public EquipmentModelStateHourlyEarnings update(UUID id, EquipmentModelStateHourlyEarningsRequest request) {
        EquipmentState equipmentState = equipmentStateCrudService.getById(request.getEquipmentStateId());
        EquipmentModel equipmentModel = equipmentModelCrudService.getById(request.getEquipmentModelId());
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = this.getById(id);
        equipmentModelStateHourlyEarnings.setEquipmentModel(equipmentModel);
        equipmentModelStateHourlyEarnings.setEquipmentState(equipmentState);
        equipmentModelStateHourlyEarnings.setValue(request.getValue());
        return equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
    }

    @Override
    public void delete(UUID id) {
        equipmentModelStateHourlyEarningsRepository.deleteById(id);
    }
}
