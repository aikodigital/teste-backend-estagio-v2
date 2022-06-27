package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentStateHistoryResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentStateHistoryDtoConversionService {

    public EquipmentStateHistoryResponse toDto(EquipmentStateHistory equipmentStateHistory){
        return new EquipmentStateHistoryResponse(equipmentStateHistory);
    }

    public List<EquipmentStateHistoryResponse> toDtoList(List<EquipmentStateHistory> equipmentStateHistoryList){
        return equipmentStateHistoryList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
