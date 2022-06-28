package com.equipments.apirest.controllers;


import com.equipments.apirest.controllers.dtos.request.EquipmentStateHistoryRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentStateHistoryResponse;
import com.equipments.apirest.models.EquipmentStateHistoryId;
import com.equipments.apirest.services.EquipmentStateHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipment-state-history")
@AllArgsConstructor
public class EquipmentStateHistoryController {

    @Autowired
    EquipmentStateHistoryService equipmentStateHistoryService;

    @GetMapping
    public List<EquipmentStateHistoryResponse> listEquipmentHistory() {
        final var equipmentHistories = this.equipmentStateHistoryService.findAll();
        return equipmentHistories.stream().map(EquipmentStateHistoryResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public EquipmentStateHistoryResponse createEquipmentHistory(@RequestBody EquipmentStateHistoryRequest equipmentStateHistoryRequest) {
        var equipmentHistory = equipmentStateHistoryRequest.toModel();
        equipmentHistory = this.equipmentStateHistoryService.create(equipmentHistory);
        return new EquipmentStateHistoryResponse(equipmentHistory);
    }

    @PutMapping
    public EquipmentStateHistoryResponse updateEquipmentHistory(@RequestBody EquipmentStateHistoryRequest equipmentStateHistoryRequest) {
        var equipmentHistory = this.equipmentStateHistoryService.findById(equipmentStateHistoryRequest.toModel().getId());
        equipmentHistory.setDate(equipmentStateHistoryRequest.getDate());
        equipmentHistory = this.equipmentStateHistoryService.update(equipmentHistory);
        return new EquipmentStateHistoryResponse(equipmentHistory);
    }

    @DeleteMapping
    public void deleteById(@RequestBody EquipmentStateHistoryId id) {
        equipmentStateHistoryService.deleteById(id);
    }
}
