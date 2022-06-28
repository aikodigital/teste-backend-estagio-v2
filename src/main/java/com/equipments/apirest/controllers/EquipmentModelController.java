package com.equipments.apirest.controllers;


import com.equipments.apirest.controllers.dtos.request.EquipmentModelRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentModelResponse;
import com.equipments.apirest.services.EquipmentModelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipment-models")
@AllArgsConstructor
public class EquipmentModelController {

    @Autowired
    EquipmentModelService equipmentModelService;


    @GetMapping
    public List<EquipmentModelResponse> listEquipmentModels() {
        final var equipmentModels = this.equipmentModelService.findAll();
        return equipmentModels.stream().map(EquipmentModelResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public EquipmentModelResponse getById(@PathVariable UUID id) {
        final var equipmentModel = this.equipmentModelService.findById(id);
        return new EquipmentModelResponse(equipmentModel);
    }

    @PostMapping
    public EquipmentModelResponse createEquipmentModel(@RequestBody EquipmentModelRequest equipmentModelRequest) {
        var equipmentModel = equipmentModelRequest.toModel();
        equipmentModel = this.equipmentModelService.create(equipmentModel);
        return new EquipmentModelResponse(equipmentModel);
    }

    @PutMapping(value = "/{id}")
    public EquipmentModelResponse updateEquipmentModel(@PathVariable UUID id, @RequestBody EquipmentModelRequest equipmentModelRequest) {
        var equipmentModel = this.equipmentModelService.findById(id);
        equipmentModel.setName(equipmentModelRequest.getName());
        equipmentModel = this.equipmentModelService.update(equipmentModel);
        return new EquipmentModelResponse(equipmentModel);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable UUID id) {
        equipmentModelService.deleteById(id);
    }


}
