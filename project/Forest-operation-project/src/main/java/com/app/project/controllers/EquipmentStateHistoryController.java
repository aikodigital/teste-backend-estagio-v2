package com.app.project.controllers;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.services.EquipmentStateHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipment-state-history")
@RequiredArgsConstructor
public class EquipmentStateHistoryController {

    private final EquipmentStateHistoryService service;

    @PostMapping
    public ResponseEntity<EquipmentStateHistory> post(@RequestBody EquipStateHistoryPostRequest equipStateHistory) throws NotFoundException {
        return new ResponseEntity<>(service.save(equipStateHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentStateHistory>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentStateHistory> getById(@PathVariable UUID id) throws NotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
