package com.app.project.controllers;

import com.app.project.domain.Equipment;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.services.EquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipService service;

    @PostMapping
    public ResponseEntity<Equipment> save(@RequestBody @Validated EquipPostRequest equipment) {
        return new ResponseEntity<>(service.save(equipment), HttpStatus.CREATED);
    }
}
