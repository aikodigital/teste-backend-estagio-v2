package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.services.EquipmentStateHistoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequestMapping(value = "/api/states/")
public class EquipmentStateHistoryController {
 
    private EquipmentStateHistoryService stateHistoryService;
    private final String HISTORY_PATH = "/history";

    public EquipmentStateHistoryController(EquipmentStateHistoryService stateHistoryService) {
        this.stateHistoryService = stateHistoryService;
    }

    @GetMapping(value = HISTORY_PATH)
    public ResponseEntity<List<EquipmentStateHistory>> findAllStatesHistories(){
        return ResponseEntity.ok().body(stateHistoryService.findAll());
    }

    @GetMapping(value = HISTORY_PATH+"/{equipmentId}")
    public ResponseEntity<List<EquipmentStateHistory>> findStateHistoriesByEquipmentId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(stateHistoryService.findStateHistoriesByEquipmentId(equipmentId));
    }

    @PostMapping(value = HISTORY_PATH+"/save")
    public ResponseEntity<EquipmentStateHistory> saveStateHistory(@RequestBody EquipmentStateHistory obj){
        EquipmentStateHistory savedStateHistory = stateHistoryService.save(obj);
        if(savedStateHistory == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStateHistory);
        }
    }

    @PutMapping(value = HISTORY_PATH+"/update")
    public ResponseEntity<EquipmentStateHistory> updateStateHistory(@RequestBody List<EquipmentStateHistory> objs) {
        return ResponseEntity.ok().body(stateHistoryService.update(objs));
    }

    @DeleteMapping(value = HISTORY_PATH+"/delete")
    public ResponseEntity<Void> deleteStateHistoryById(@RequestBody EquipmentStateHistory obj){
        stateHistoryService.deleteById(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/current/{equipmentId}")
    public ResponseEntity<EquipmentStateHistory> findCurrentEquipmetState(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(stateHistoryService.findCurrentState(equipmentId));
    }

}