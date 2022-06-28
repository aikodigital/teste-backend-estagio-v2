package com.equipments.apirest.controllers;

import com.equipments.apirest.controllers.dtos.request.EquipmentStateRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentStateResponse;
import com.equipments.apirest.services.EquipmentStateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipment-state")
@AllArgsConstructor
public class EquipmentStateController {

    @Autowired
    EquipmentStateService equipmentStateService;

    @GetMapping
    public List<EquipmentStateResponse> listEquipmentStates() {
        final var equipmentStates = this.equipmentStateService.findAll();
        return equipmentStates.stream().map(EquipmentStateResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{equipmentStateId}")
    public EquipmentStateResponse getById(@PathVariable UUID equipmentStateId) {
        final var equipmentState = this.equipmentStateService.findById(equipmentStateId);
        return new EquipmentStateResponse(equipmentState);
    }

    @PostMapping
    public EquipmentStateResponse createEquipmentState(@RequestBody EquipmentStateRequest equipmentStateRequest) {
        var equipmentState = equipmentStateRequest.toModel();
        equipmentState = this.equipmentStateService.create(equipmentState);
        return new EquipmentStateResponse(equipmentState);
    }

    @PutMapping(value = "/{equipmentStateId}")
    public EquipmentStateResponse updateEquipmentState(@PathVariable UUID equipmentStateId, @RequestBody EquipmentStateRequest equipmentStateRequest) {
        var equipmentState = this.equipmentStateService.findById(equipmentStateId);
        equipmentState.setName(equipmentStateRequest.getName());
        equipmentState.setColor(equipmentStateRequest.getColor());
        equipmentState = this.equipmentStateService.update(equipmentState);
        return new EquipmentStateResponse(equipmentState);
    }

    @DeleteMapping(value = "{equipmentStateId}")
    public void deleteById(@PathVariable UUID equipmentStateId) {
        equipmentStateService.deleteById(equipmentStateId);
    }
}
