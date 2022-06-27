package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarnings;
import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarningsId;
import com.brunozarth.testeaiko.repository.EquipmentModelStateHourlyEarningsRepository;
import com.brunozarth.testeaiko.requests.equipmentModelStateHourlyEarnings.EquipmentModelStateHourlyEarningsPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentModelStateHourlyEarnings.EquipmentModelStateHourlyEarningsPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentModelStateHourlyEarningsService {

    private final EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;
    private final EquipmentModelService equipmentModelService;
    private final EquipmentStateService equipmentStateService;

    @Autowired
    public EquipmentModelStateHourlyEarningsService(
            EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
            EquipmentModelService equipmentModelService,
            EquipmentStateService equipmentStateService){
        this.equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
        this.equipmentModelService = equipmentModelService;
        this.equipmentStateService = equipmentStateService;
    }

    public List<EquipmentModelStateHourlyEarnings> findAll(){
        return equipmentModelStateHourlyEarningsRepository.findAll();
    }

    public EquipmentModelStateHourlyEarnings findByIdOrThrowBadRequestException(EquipmentModelStateHourlyEarningsId id){
        return equipmentModelStateHourlyEarningsRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment model state hourly earnings id not found!"));
    }

    public List<EquipmentModelStateHourlyEarnings> findByEquipmentModelId(UUID id){
        return equipmentModelStateHourlyEarningsRepository.findByIdEquipmentModelId(id);
    }

    public List<EquipmentModelStateHourlyEarnings> findByEquipmentStateId(UUID id){
        return equipmentModelStateHourlyEarningsRepository.findByIdEquipmentStateId(id);
    }

    public EquipmentModelStateHourlyEarnings saveEquipmentModelStateHourlyEarnings(
            EquipmentModelStateHourlyEarningsPostRequestBody equipmentModelStateHourlyEarningsPostRequestBody){

        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = EquipmentModelStateHourlyEarnings.builder()
                .id(equipmentModelStateHourlyEarningsPostRequestBody.getId())
                .value(equipmentModelStateHourlyEarningsPostRequestBody.getValue())
                .build();

        equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
        this.findByIdOrThrowBadRequestException(equipmentModelStateHourlyEarnings.getId());
        return equipmentModelStateHourlyEarnings;
    }

    public void deleteEquipmentModelStateHourlyEarningsById(EquipmentModelStateHourlyEarningsId id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentModelStateHourlyEarningsRepository.deleteById(id);
    }

    public EquipmentModelStateHourlyEarnings replaceEquipmentModelStateHourlyEarnings(EquipmentModelStateHourlyEarningsPutRequestBody equipmentModelStateHourlyEarningsPutRequestBody) {
        EquipmentModelStateHourlyEarnings savedEquipmentModelStateHourlyEarnings = this.findByIdOrThrowBadRequestException(equipmentModelStateHourlyEarningsPutRequestBody.getId());
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = EquipmentModelStateHourlyEarnings.builder()
                .id(equipmentModelStateHourlyEarningsPutRequestBody.getId())
                .value(equipmentModelStateHourlyEarningsPutRequestBody.getValue())
                .build();

        equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
        return equipmentModelStateHourlyEarnings;
    }
}
