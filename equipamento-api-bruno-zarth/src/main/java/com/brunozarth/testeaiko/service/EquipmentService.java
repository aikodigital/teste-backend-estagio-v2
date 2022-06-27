package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.Equipment;
import com.brunozarth.testeaiko.repository.EquipmentRepository;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPostRequestBody;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentModelService equipmentModelService;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentModelService equipmentModelService){
        this.equipmentRepository = equipmentRepository;
        this.equipmentModelService = equipmentModelService;
    }

    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }

    public Equipment findByIdOrThrowBadRequestException(UUID id){
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment id not found!"));
    }

    public List<Equipment> findByName(String name){
        return equipmentRepository.findByName(name);
    }

    public Equipment saveEquipment(EquipmentPostRequestBody equipmentPostRequestBody){
        if(equipmentModelService.findByName(equipmentPostRequestBody.getEquipmentModel().getName()).isEmpty()){
            equipmentPostRequestBody.getEquipmentModel().setName(equipmentModelService.findByIdOrThrowBadRequestException(
                    equipmentPostRequestBody.getEquipmentModel().getId()).getName());
        }

        Equipment equipment = Equipment.builder()
                .name(equipmentPostRequestBody.getName())
                .equipmentModel(equipmentPostRequestBody.getEquipmentModel())
                .build();

        equipmentRepository.save(equipment);
        this.findByIdOrThrowBadRequestException(equipment.getId());
        return equipment;
    }

    public void deleteEquipmentById(UUID id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentRepository.deleteById(id);
    }

    public Equipment replaceEquipment(EquipmentPutRequestBody equipmentPutRequestBody) {
        Equipment savedEquipment = this.findByIdOrThrowBadRequestException(equipmentPutRequestBody.getId());
        Equipment equipment = Equipment.builder()
                .id(equipmentPutRequestBody.getId())
                .name(equipmentPutRequestBody.getName())
                .equipmentModel(equipmentPutRequestBody.getEquipmentModel())
                .build();

        equipmentRepository.save(equipment);
        return equipment;
    }

}
