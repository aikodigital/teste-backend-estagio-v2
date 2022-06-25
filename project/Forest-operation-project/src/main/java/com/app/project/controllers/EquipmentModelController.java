package com.app.project.controllers;

import com.app.project.domain.EquipmentModel;
import com.app.project.requests.EquipmentModelPostRequest;
import com.app.project.services.EquipmentModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipment-model")
public class EquipmentModelController {

    private final EquipmentModelService service;

    @PostMapping
    public ResponseEntity<EquipmentModel> post(@RequestBody @Valid EquipmentModelPostRequest equipmentModel) {
        return new ResponseEntity<>(service.save(equipmentModel), HttpStatus.CREATED);
    }
}
