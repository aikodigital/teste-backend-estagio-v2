package com.app.project.controllers;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.services.EquipmentStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment-state")
@RequiredArgsConstructor
public class EquipmentStateController {

    private final EquipmentStateService service;

    @PostMapping
    public ResponseEntity<EquipmentState> post(@RequestBody EquipStatePostRequest postRequest) {
        return new ResponseEntity<>(service.save(postRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentState>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentState> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
