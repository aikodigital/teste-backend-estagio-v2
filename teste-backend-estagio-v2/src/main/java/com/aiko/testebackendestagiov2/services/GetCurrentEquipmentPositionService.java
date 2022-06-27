package com.aiko.testebackendestagiov2.services;

import com.aiko.testebackendestagiov2.dtos.responses.CurrentEquipmentPositionResponse;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.services.ImplCrud.EquipmentCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCurrentEquipmentPositionService {

    private final EquipmentCrudService equipmentCrudService;

    public List<CurrentEquipmentPositionResponse> execute(){
        List<Equipment> equipmentList = equipmentCrudService.getAll();
        List<CurrentEquipmentPositionResponse> currentEquipmentStateResponseList = equipmentList.stream()
                .map(equipment -> toCurrentEquipmentPositionResponse(equipment))
                .collect(Collectors.toList());
        return currentEquipmentStateResponseList;
    }

    private CurrentEquipmentPositionResponse toCurrentEquipmentPositionResponse(Equipment equipment){
        CurrentEquipmentPositionResponse currentEquipmentPositionResponse = new CurrentEquipmentPositionResponse();
        currentEquipmentPositionResponse.setEquipmentId(equipment.getId());
        currentEquipmentPositionResponse.setEquipmentName(equipment.getName());

        List<EquipmentPositionHistory> equipmentPositionHistoryList = equipment.getEquipmentPositionHistories();
        if(!equipmentPositionHistoryList.isEmpty()){
            int lastIndex = equipmentPositionHistoryList.size() - 1;
            currentEquipmentPositionResponse.setLat(equipmentPositionHistoryList.get(lastIndex).getLat());
            currentEquipmentPositionResponse.setLon(equipmentPositionHistoryList.get(lastIndex).getLon());
        }
        return currentEquipmentPositionResponse;
    }
}
