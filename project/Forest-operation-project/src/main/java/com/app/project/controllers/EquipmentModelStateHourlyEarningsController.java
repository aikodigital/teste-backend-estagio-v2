package com.app.project.controllers;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.EquipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.services.EquipmentModelStateHourlyEarningsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipment-model-state-hourly-earnings")
public class EquipmentModelStateHourlyEarningsController {
    private final EquipmentModelStateHourlyEarningsService service;

    @PostMapping
    public ResponseEntity<EquipmentModelStateHourlyEarnings> post(
            @RequestBody EquipModelStateHourlyEarningsPostRequest postRequest) throws NotFoundException {
        return new ResponseEntity<>(service.save(postRequest), HttpStatus.CREATED);
    }
}
