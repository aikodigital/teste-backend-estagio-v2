package com.app.project.controllers;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.services.EquipmentStateHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment-state-history")
@RequiredArgsConstructor
public class EquipmentStateHistoryController {

    private final EquipmentStateHistoryService service;

    @PostMapping
    public ResponseEntity<EquipmentStateHistory> post(@RequestBody EquipStateHistoryPostRequest equipStateHistory) throws NotFoundException {
        return new ResponseEntity<>(service.save(equipStateHistory), HttpStatus.CREATED);
    }
}
