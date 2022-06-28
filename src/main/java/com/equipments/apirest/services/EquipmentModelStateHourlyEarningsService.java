package com.equipments.apirest.services;

import com.equipments.apirest.models.EquipmentModelStateHourlyEarnings;
import com.equipments.apirest.repositories.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentModelStateHourlyEarningsService {

    private final EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    private final EquipmentModelService equipmentModelService;

    private final EquipmentStateService equipmentStateService;

    public EquipmentModelStateHourlyEarningsService(EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
                                                    EquipmentModelService equipmentModelService,
                                                    EquipmentStateService equipmentStateService) {
        this.equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
        this.equipmentModelService = equipmentModelService;
        this.equipmentStateService = equipmentStateService;
    }

    public List<EquipmentModelStateHourlyEarnings> findAll(UUID modelId, UUID stateId) {
        return equipmentModelStateHourlyEarningsRepository.findAll(modelId, stateId);
    }

    public EquipmentModelStateHourlyEarnings create(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        final var equipmentModel = equipmentModelService.findById(equipmentModelStateHourlyEarnings.getId().getEquipmentModel().getId());
        final var equipmentState = equipmentStateService.findById(equipmentModelStateHourlyEarnings.getId().getEquipmentState().getId());

        equipmentModelStateHourlyEarnings.getId().setEquipmentModel(equipmentModel);
        equipmentModelStateHourlyEarnings.getId().setEquipmentState(equipmentState);

        return this.equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
    }

}