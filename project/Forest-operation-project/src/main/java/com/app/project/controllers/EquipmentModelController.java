package com.app.project.controllers;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipModel.EquipmentModelPostRequest;
import com.app.project.requests.equipModel.EquipmentModelPutRequest;
import com.app.project.services.EquipmentModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipment-models")
public class EquipmentModelController {

    private final EquipmentModelService service;

    @GetMapping
    public ResponseEntity<List<EquipmentModel>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentModel> getById(@PathVariable UUID id) throws NotFoundException {
        return new ResponseEntity<>(service.findByIdOrThrowNotFoundException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentModel> post(@RequestBody @Valid EquipmentModelPostRequest equipmentModel) {
        return new ResponseEntity<>(service.save(equipmentModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> put(@RequestBody EquipmentModelPutRequest putRequest) throws NotFoundException {
        service.update(putRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

