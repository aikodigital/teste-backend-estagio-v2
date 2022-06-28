package com.app.project.controllers;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPutRequest;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.services.EquipmentStateHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipment-state-history")
@RequiredArgsConstructor
public class EquipmentStateHistoryController {

    private final EquipmentStateHistoryService service;

    @GetMapping
    public ResponseEntity<List<EquipmentStateHistory>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentStateHistory> getById(@PathVariable UUID id) throws NotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentStateHistory> post(@RequestBody @Valid EquipStateHistoryPostRequest equipStateHistory) throws NotFoundException {
        return new ResponseEntity<>(service.save(equipStateHistory), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> put(@RequestBody EquipStateHistoryPutRequest putRequest) throws NotFoundException {
        service.update(putRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
