package com.equipments.apirest.controllers;

import com.equipments.apirest.controllers.dtos.request.EquipmentRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentResponse;
import com.equipments.apirest.services.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipments")
@AllArgsConstructor
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @GetMapping
    public List<EquipmentResponse> listEquipments() {
        final var equipments = this.equipmentService.findAll();
        return equipments.stream().map(EquipmentResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{equipmentId}")
    public EquipmentResponse getById(@PathVariable UUID equipmentId) {
        final var equipment = this.equipmentService.findById(equipmentId);
        return new EquipmentResponse(equipment);
    }

    @PostMapping
    public EquipmentResponse createEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        var equipment = equipmentRequest.toModel();
        equipment = this.equipmentService.create(equipment);
        return new EquipmentResponse(equipment);
    }

    @PutMapping(value = "/{equipmentId}")
    public EquipmentResponse updateEquipment(@PathVariable UUID equipmentId, @RequestBody EquipmentRequest equipmentRequest) {
        var equipment = this.equipmentService.findById(equipmentId);
        equipment.setName(equipmentRequest.getName());
        equipment.setEquipmentModel(equipment.getEquipmentModel());
        equipment = this.equipmentService.update(equipment);
        return new EquipmentResponse(equipment);
    }

    @DeleteMapping(value = "/{equipmentId}")
    public void deleteById(@PathVariable UUID equipmentId) {
        equipmentService.deleteById(equipmentId);
    }

}
