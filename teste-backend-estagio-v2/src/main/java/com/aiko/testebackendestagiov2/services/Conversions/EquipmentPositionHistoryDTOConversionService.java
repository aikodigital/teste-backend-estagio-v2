package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentPositionHistoryResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentPositionHistoryDTOConversionService {

    public EquipmentPositionHistoryResponse toDto(EquipmentPositionHistory equipmentPositionHistory){
        return new EquipmentPositionHistoryResponse(equipmentPositionHistory);
    }

    public List<EquipmentPositionHistoryResponse> toDtoList(List<EquipmentPositionHistory> equipmentPositionHistoryList){
        return equipmentPositionHistoryList.stream()
                .map(equipmentPositionHistory -> this.toDto(equipmentPositionHistory))
                .collect(Collectors.toList());
    }
}
