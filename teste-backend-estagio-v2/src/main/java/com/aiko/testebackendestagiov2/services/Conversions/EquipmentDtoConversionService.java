package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentResponse;
import com.aiko.testebackendestagiov2.entities.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentDtoConversionService {

    public EquipmentResponse toEquipmentResponse(Equipment equipment){
        return new EquipmentResponse(equipment);
    }

    public List<EquipmentResponse> toEquipmentListResponse(List<Equipment> equipments){
        List<EquipmentResponse> equipmentResponseList = equipments.stream()
                .map(equipment -> this.toEquipmentResponse(equipment))
                .collect(Collectors.toList());
        return equipmentResponseList;
    }
}
