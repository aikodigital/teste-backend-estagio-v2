package com.app.project.controllers;

import com.app.project.domain.EquipmentState;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.services.EquipmentStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment-state")
@RequiredArgsConstructor
public class EquipmentStateController {

    private final EquipmentStateService service;

    @PostMapping
    public ResponseEntity<EquipmentState> post(@RequestBody EquipStatePostRequest postRequest) {
        return new ResponseEntity<>(service.save(postRequest), HttpStatus.CREATED);
    }
}
