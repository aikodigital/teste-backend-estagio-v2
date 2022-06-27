package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.EquipmentModel;
import com.brunozarth.testeaiko.repository.EquipmentModelRepository;
import com.brunozarth.testeaiko.requests.equipmentModel.EquipmentModelPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentModel.EquipmentModelPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentModelService {

    private final EquipmentModelRepository equipmentModelRepository;

    @Autowired
    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository){
        this.equipmentModelRepository = equipmentModelRepository;
    }

    public List<EquipmentModel> findAll(){
        return equipmentModelRepository.findAll();
    }
    public List<EquipmentModel> findByName(String name){
        return equipmentModelRepository.findByName(name);
    }
    public EquipmentModel findByIdOrThrowBadRequestException(UUID id){
        return equipmentModelRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment model id not found!"));
    }

    public EquipmentModel saveEquipmentModel(EquipmentModelPostRequestBody equipmentModelPostRequestBody){

        EquipmentModel equipmentModel = EquipmentModel.builder()
                .name(equipmentModelPostRequestBody.getName())
                .build();

        equipmentModelRepository.save(equipmentModel);
        this.findByIdOrThrowBadRequestException(equipmentModel.getId());
        return equipmentModel;
    }

    public void deleteEquipmentModelById(UUID id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentModelRepository.deleteById(id);
    }

    public EquipmentModel replaceEquipmentModel(EquipmentModelPutRequestBody equipmentModelPutRequestBody) {
        EquipmentModel savedEquipmentModel = this.findByIdOrThrowBadRequestException(equipmentModelPutRequestBody.getId());
        EquipmentModel equipmentModel = EquipmentModel.builder()
                .id(equipmentModelPutRequestBody.getId())
                .name(equipmentModelPutRequestBody.getName())
                .build();

        equipmentModelRepository.save(equipmentModel);
        return equipmentModel;
    }
}
