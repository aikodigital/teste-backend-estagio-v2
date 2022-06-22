package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.EquipmentModelStateHourlyEarnings;
import com.pedroacbg.api.services.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/equipments/earnings")
public class EquipmentModelStateHourlyEarningsResource {

    @Autowired
    private EquipmentModelStateHourlyEarningsService service;

    @GetMapping
    public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{modelId}/{stateId}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> findById(@PathVariable UUID modelId, @PathVariable UUID stateId){
        return ResponseEntity.ok().body(service.findById(modelId, stateId));
    }

    @PostMapping
    public ResponseEntity<EquipmentModelStateHourlyEarnings> insert(@RequestBody EquipmentModelStateHourlyEarnings obj){
        EquipmentModelStateHourlyEarnings newObj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
    }

    @PutMapping(value = "/{modelId}/{stateId}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> update(@PathVariable UUID modelId, @PathVariable UUID stateId, @RequestBody EquipmentModelStateHourlyEarnings obj){
        return ResponseEntity.ok().body(service.update(modelId, stateId, obj));
    }

    @DeleteMapping(value = "/{modelId}/{stateId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID modelId, @PathVariable UUID stateId){
        service.delete(modelId, stateId);
        return ResponseEntity.noContent().build();
    }


}
