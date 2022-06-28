package com.app.project.controllers;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPutRequest;
import com.app.project.services.EquipmentModelStateHourlyEarningsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> getById(@PathVariable UUID id) throws NotFoundException {
        return new ResponseEntity<>(service.findByIdOrThrowsNotFoundException(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> put(@RequestBody EquipModelStateHourlyEarningsPutRequest putRequest) throws NotFoundException {
        service.update(putRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
