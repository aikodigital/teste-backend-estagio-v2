package com.equipments.apirest.controllers;

import com.equipments.apirest.controllers.dtos.request.EquipmentPositionHistoryRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentPositionHistoryResponse;
import com.equipments.apirest.models.Equipment;
import com.equipments.apirest.models.EquipmentPositionHistoryId;
import com.equipments.apirest.services.EquipmentPositionHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipments/{equipmentId}/equipment-position-history")
@AllArgsConstructor
public class EquipmentPositionHistoryController {

    @Autowired
    EquipmentPositionHistoryService equipmentPositionHistoryService;

    @GetMapping
    public List<EquipmentPositionHistoryResponse> listEquipmentPositions(@PathVariable UUID equipmentId) {
        final var equipmentPositions = this.equipmentPositionHistoryService.findALl(equipmentId);

        return equipmentPositions.stream()
                .map(EquipmentPositionHistoryResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public EquipmentPositionHistoryResponse createEquipmentPosition(@PathVariable UUID equipmentId, @RequestBody EquipmentPositionHistoryRequest equipmentPositionHistoryRequest) {
        var equipmentPosition = equipmentPositionHistoryRequest.toModel();
        equipmentPosition.setEquipmentPositionHistoryId(new EquipmentPositionHistoryId());
        equipmentPosition.getEquipmentPositionHistoryId().setEquipment(new Equipment());
        equipmentPosition.getEquipmentPositionHistoryId().getEquipment().setId(equipmentId);

        equipmentPosition = this.equipmentPositionHistoryService.create(equipmentPosition);

        return new EquipmentPositionHistoryResponse(equipmentPosition);
    }

}
