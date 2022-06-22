package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.EquipmentPositionHistory;
import com.pedroacbg.api.services.EquipmentPositionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/equipments/history/position")
public class EquipmentPositionHistoryResource {

    @Autowired
    private EquipmentPositionHistoryService service;

    @GetMapping
    public ResponseEntity<List<EquipmentPositionHistory>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{equipmentId}")
    public ResponseEntity<List<EquipmentPositionHistory>> findPositionByEquipmentId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(service.findByEquipmentId(equipmentId));
    }

    @PostMapping
    public ResponseEntity<EquipmentPositionHistory> insert(@RequestBody EquipmentPositionHistory obj){
        EquipmentPositionHistory newObj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
    }

    @PutMapping(value = "/{equipmentId}")
    public ResponseEntity<EquipmentPositionHistory> update(@PathVariable UUID equipmentId, @RequestBody EquipmentPositionHistory obj){
        EquipmentPositionHistory newObj = service.update(equipmentId, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deletePositionById(@PathVariable UUID equipmentId, @RequestBody EquipmentPositionHistory obj){
        service.deleteById(equipmentId, obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/current/{equipmentId}")
    public ResponseEntity<EquipmentPositionHistory> findCurrentPosition(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(service.findEquipmentCurrentPosition(equipmentId));
    }

}
