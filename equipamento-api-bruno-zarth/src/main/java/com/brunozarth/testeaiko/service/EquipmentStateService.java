package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.Equipment;
import com.brunozarth.testeaiko.model.EquipmentState;
import com.brunozarth.testeaiko.repository.EquipmentRepository;
import com.brunozarth.testeaiko.repository.EquipmentStateRepository;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPostRequestBody;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPutRequestBody;
import com.brunozarth.testeaiko.requests.equipmentState.EquipmentStatePostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentState.EquipmentStatePutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentStateService {

    private final EquipmentStateRepository equipmentStateRepository;

    @Autowired
    public EquipmentStateService(EquipmentStateRepository equipmentStateRepository, EquipmentModelService equipmentModelService){
        this.equipmentStateRepository = equipmentStateRepository;
    }

    public List<EquipmentState> findAll(){
        return equipmentStateRepository.findAll();
    }

    public EquipmentState findByIdOrThrowBadRequestException(UUID id){
        return equipmentStateRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment state id not found!"));
    }

    public List<EquipmentState> findByName(String name){
        return equipmentStateRepository.findByName(name);
    }

    public EquipmentState saveEquipmentState(EquipmentStatePostRequestBody equipmentStatePostRequestBody){

        EquipmentState equipmentState = EquipmentState.builder()
                .name(equipmentStatePostRequestBody.getName())
                .color(equipmentStatePostRequestBody.getColor())
                .build();

        equipmentStateRepository.save(equipmentState);
        this.findByIdOrThrowBadRequestException(equipmentState.getId());
        return equipmentState;
    }

    public void deleteEquipmentStateById(UUID id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentStateRepository.deleteById(id);
    }

    public EquipmentState replaceEquipmentState(EquipmentStatePutRequestBody equipmentStatePutRequestBody) {
        EquipmentState savedEquipmentState = this.findByIdOrThrowBadRequestException(equipmentStatePutRequestBody.getId());
        EquipmentState equipmentState = EquipmentState.builder()
                .id(equipmentStatePutRequestBody.getId())
                .name(equipmentStatePutRequestBody.getName())
                .color(equipmentStatePutRequestBody.getColor())
                .build();

        equipmentStateRepository.save(equipmentState);
        return equipmentState;
    }

}
