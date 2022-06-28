package com.app.project.controllers;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPutRequest;
import com.app.project.services.EquipmentPositionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipment-position-history")
@RequiredArgsConstructor
public class EquipmentPositionHistoryController {

    private final EquipmentPositionHistoryService service;

    @GetMapping
    public ResponseEntity<List<EquipmentPositionHistory>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentPositionHistory> getById(@PathVariable UUID id) throws NotFoundException {
        return new ResponseEntity<>(service.findByIdOrThrowsNotFoundException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentPositionHistory> post(@RequestBody EquipPositionHistoryPostRequest postRequest) throws NotFoundException {
        return new ResponseEntity<>(service.save(postRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> put(@RequestBody EquipPositionHistoryPutRequest putRequest) throws NotFoundException {
        service.update(putRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
