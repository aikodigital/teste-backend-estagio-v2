package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.Equipment;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPostRequestBody;
import com.brunozarth.testeaiko.requests.equipment.EquipmentPutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping
    private ResponseEntity<List<Equipment>> equipmentList(){
        return ResponseEntity.ok(equipmentService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Equipment> findById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/name")
    private ResponseEntity<List<Equipment>> findByName(@RequestParam String name){
        return ResponseEntity.ok(equipmentService.findByName(name));
    }

    @PostMapping("/saveEquipment")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Equipment> saveEquipment(@RequestBody @Valid EquipmentPostRequestBody equipmentPostRequestBody){
        return new ResponseEntity<>(equipmentService.saveEquipment(equipmentPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipment/{id}")
    private ResponseEntity<Void> deleteEquipmentById(@PathVariable UUID id){
        equipmentService.deleteEquipmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipment")
    private ResponseEntity<Equipment> replaceEquipment(@RequestBody @Valid EquipmentPutRequestBody equipmentPutRequestBody){
        return new ResponseEntity<>(equipmentService.replaceEquipment(equipmentPutRequestBody), HttpStatus.CREATED);
    }


}
