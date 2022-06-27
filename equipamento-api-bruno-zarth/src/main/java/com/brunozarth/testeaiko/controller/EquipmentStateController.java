package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.EquipmentState;
import com.brunozarth.testeaiko.requests.equipmentState.EquipmentStatePostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentState.EquipmentStatePutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipmentState")
public class EquipmentStateController {

    private final EquipmentStateService equipmentStateService;

    @Autowired
    public EquipmentStateController(EquipmentStateService equipmentStateService){
        this.equipmentStateService = equipmentStateService;
    }

    @GetMapping
    private ResponseEntity<List<EquipmentState>> EquipmentStateList(){
        return ResponseEntity.ok(equipmentStateService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<EquipmentState> findById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentStateService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/name")
    private ResponseEntity<List<EquipmentState>> findByName(@RequestParam String name){
        return ResponseEntity.ok(equipmentStateService.findByName(name));
    }

    @PostMapping("/saveEquipmentState")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EquipmentState> saveEquipmentState(@RequestBody @Valid EquipmentStatePostRequestBody equipmentStatePostRequestBody){
        return new ResponseEntity<>(equipmentStateService.saveEquipmentState(equipmentStatePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipmentState/{id}")
    private ResponseEntity<Void> deleteEquipmentStateById(@PathVariable UUID id){
        equipmentStateService.deleteEquipmentStateById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipmentState")
    private ResponseEntity<EquipmentState> replaceEquipment(@RequestBody @Valid EquipmentStatePutRequestBody EquipmentStatePutRequestBody){
        return new ResponseEntity<>(equipmentStateService.replaceEquipmentState(EquipmentStatePutRequestBody), HttpStatus.CREATED);
    }

}
