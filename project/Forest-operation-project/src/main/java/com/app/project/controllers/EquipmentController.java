package com.app.project.controllers;

import com.app.project.domain.Equipment;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.services.EquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipService service;

    @GetMapping
    public ResponseEntity<List<Equipment>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Equipment> save(@RequestBody @Validated EquipPostRequest equipment) {
        return new ResponseEntity<>(service.save(equipment), HttpStatus.CREATED);
    }
}
