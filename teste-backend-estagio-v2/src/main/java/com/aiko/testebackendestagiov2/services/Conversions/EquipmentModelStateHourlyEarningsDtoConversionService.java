package com.aiko.testebackendestagiov2.services.Conversions;

import com.aiko.testebackendestagiov2.dtos.responses.EquipmentModelStateHourlyEarningsResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentModelStateHourlyEarningsDtoConversionService {

    public EquipmentModelStateHourlyEarningsResponse toDto(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        return new EquipmentModelStateHourlyEarningsResponse(equipmentModelStateHourlyEarnings);
    }

    public List<EquipmentModelStateHourlyEarningsResponse> toDtoList(List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarningsList){
        List<EquipmentModelStateHourlyEarningsResponse> equipmentModelStateHourlyEarningsResponseList = equipmentModelStateHourlyEarningsList.stream()
                .map(equipment -> this.toDto(equipment))
                .collect(Collectors.toList());
        return equipmentModelStateHourlyEarningsResponseList;
    }
}
