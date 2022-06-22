package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.EquipmentStateHistory;
import com.pedroacbg.api.services.EquipmentStateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/history/state")
public class EquipmentStateHistoryResource {

    @Autowired
    private EquipmentStateHistoryService service;

    @GetMapping
    public ResponseEntity<List<EquipmentStateHistory>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{equipmentId}")
    public ResponseEntity<List<EquipmentStateHistory>> findStateHistoryByEquipmentId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(service.findStateHistoryByEquipmentId(equipmentId));
    }

    @PostMapping
    public ResponseEntity<EquipmentStateHistory> insert(@RequestBody EquipmentStateHistory obj){
        EquipmentStateHistory update = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(update);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<EquipmentStateHistory> update(@RequestBody List<EquipmentStateHistory> objs){
        return ResponseEntity.ok().body(service.update(objs));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestBody EquipmentStateHistory obj){
        service.deleteById(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/current/{equipmentId}")
    public ResponseEntity<EquipmentStateHistory> findCurrentStateByEquipmentId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(service.findCurrentStateByEquipmentId(equipmentId));
    }

}
