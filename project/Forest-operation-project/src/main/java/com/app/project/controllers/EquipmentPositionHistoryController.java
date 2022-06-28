package com.app.project.controllers;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.services.EquipmentPositionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment-position-history")
@RequiredArgsConstructor
public class EquipmentPositionHistoryController {

    private final EquipmentPositionHistoryService service;

    @PostMapping
    public ResponseEntity<EquipmentPositionHistory> post(@RequestBody EquipPositionHistoryPostRequest postRequest) throws NotFoundException {
        return new ResponseEntity<>(service.save(postRequest), HttpStatus.CREATED);
    }
}
