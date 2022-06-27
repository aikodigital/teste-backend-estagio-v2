package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentModelResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentModelDtoConversioService {

    public EquipmentModelResponse toEquipmentModelResponse(EquipmentModel equipmentModel){
        return new EquipmentModelResponse(equipmentModel);
    }

    public List<EquipmentModelResponse> toEquipmentModelListResponse(List<EquipmentModel> equipmentModelList){
        List<EquipmentModelResponse> equipmentModelResponseList = equipmentModelList.stream()
                .map(equipment -> this.toEquipmentModelResponse(equipment))
                .collect(Collectors.toList());
        return equipmentModelResponseList;
    }
}
