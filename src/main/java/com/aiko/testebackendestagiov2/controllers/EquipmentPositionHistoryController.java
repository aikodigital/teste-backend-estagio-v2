package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.services.EquipmentPositionHistoryService;

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

@RestController @RequestMapping(value = "/api/positions")
public class EquipmentPositionHistoryController {
    
    private EquipmentPositionHistoryService positionHistoryService;

    private final String HISTORY_PATH = "/history";

    public EquipmentPositionHistoryController(EquipmentPositionHistoryService historyService) {
        this.positionHistoryService = historyService;
    }

    @GetMapping(value = HISTORY_PATH)
    public ResponseEntity<List<EquipmentPositionHistory>> findAllPositionHistories(){
        return ResponseEntity.ok().body(positionHistoryService.findAll());
    }

    @GetMapping(value = HISTORY_PATH+"/{equipmentId}")
    public ResponseEntity<List<EquipmentPositionHistory>> findPositionHistoriesByEquipmentId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(positionHistoryService.findPositionHistoriesByEquipmentId(equipmentId));
    }

    @PostMapping(value = HISTORY_PATH+"/save")
    public ResponseEntity<EquipmentPositionHistory> savePositionHistory(@RequestBody EquipmentPositionHistory positionHistory){
        EquipmentPositionHistory savedHistory = positionHistoryService.save(positionHistory);
        if(savedHistory == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(savedHistory);
        }
    }

    @PutMapping(value = HISTORY_PATH+"/update/{equipmentId}")
    public ResponseEntity<EquipmentPositionHistory> updatePositionHistory(@PathVariable UUID equipmentId, @RequestBody EquipmentPositionHistory obj){
        EquipmentPositionHistory savedPositionHistory = positionHistoryService.update(equipmentId, obj);
        if(savedPositionHistory == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            return ResponseEntity.ok().body(savedPositionHistory);
        }
    }

    @DeleteMapping(value = HISTORY_PATH+"/delete/{equipmentId}")
    public ResponseEntity<Void> deletePositionHistoryById(@PathVariable UUID equipmentId, @RequestBody(required = true) EquipmentPositionHistory obj){
        positionHistoryService.deleteById(equipmentId, obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/current/{equipmentId}")
    public ResponseEntity<EquipmentPositionHistory> findCurrentPositionHistory(@PathVariable UUID equipmentId){
        return ResponseEntity.ok().body(positionHistoryService.findEquipmentCurrentPosition(equipmentId));
    }

}