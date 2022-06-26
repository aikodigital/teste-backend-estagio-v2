package com.aiko.testebackendestagiov2.services;

import com.aiko.testebackendestagiov2.dtos.CurrentEquipmentStateResponse;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCurrentEquipmentStateService {

    private final EquipmentCrudService equipmentCrudService;

    public List<CurrentEquipmentStateResponse> execute(){
        List<Equipment> equipmentList = equipmentCrudService.getAll();
        List<CurrentEquipmentStateResponse> currentEquipmentStateResponseList = equipmentList.stream()
                .map(equipment -> toCurrentEquipmentStateResponse(equipment))
                .collect(Collectors.toList());
        return currentEquipmentStateResponseList;
    }

    private CurrentEquipmentStateResponse toCurrentEquipmentStateResponse(Equipment equipment){
        CurrentEquipmentStateResponse currentEquipmentStateResponse = new CurrentEquipmentStateResponse();
        currentEquipmentStateResponse.setEquipmentId(equipment.getId());
        currentEquipmentStateResponse.setEquipmentName(equipment.getName());

        List<EquipmentStateHistory> equipmentStateHistories = equipment.getEquipmentStateHistories();
        if(!equipmentStateHistories.isEmpty()){
            int lastIndex = equipmentStateHistories.size() - 1;
            currentEquipmentStateResponse.setStateName(equipmentStateHistories.get(lastIndex).getEquipmentState().getName());
            currentEquipmentStateResponse.setStateColor(equipmentStateHistories.get(lastIndex).getEquipmentState().getColor());
        }
        return currentEquipmentStateResponse;
    }
}
