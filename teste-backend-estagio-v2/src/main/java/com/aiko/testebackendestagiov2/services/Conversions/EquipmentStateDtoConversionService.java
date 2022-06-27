package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentStateResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentStateDtoConversionService {

    public EquipmentStateResponse toDto(EquipmentState equipmentState){
        return new EquipmentStateResponse(equipmentState);
    }

    public List<EquipmentStateResponse> toDtoList(List<EquipmentState> equipmentStateList){
        return equipmentStateList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
