package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.EquipmentStateHistory;
import com.brunozarth.testeaiko.model.EquipmentStateHistoryId;
import com.brunozarth.testeaiko.requests.equipmentStateHistory.EquipmentStateHistoryPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentStateHistory.EquipmentStateHistoryPutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentStateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipmentStateHistory")
public class EquipmentStateHistoryController {

    private final EquipmentStateHistoryService equipmentStateHistoryService;

    @Autowired
    public EquipmentStateHistoryController(EquipmentStateHistoryService equipmentStateHistoryService){
        this.equipmentStateHistoryService = equipmentStateHistoryService;
    }

    @GetMapping
    private ResponseEntity<List<EquipmentStateHistory>> equipmentStateHistoryList(){
        return ResponseEntity.ok(equipmentStateHistoryService.findAll());
    }

    @GetMapping("/findByEquipmentId/{equipmentId}")
    private ResponseEntity<List<EquipmentStateHistory>> findByEquipmentModelId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok(equipmentStateHistoryService.findByEquipmentId(equipmentId));
    }

    @GetMapping("/findByStateId/{stateId}")
    private ResponseEntity<List<EquipmentStateHistory>> findByEquipmentStateId(@PathVariable UUID stateId){
        return ResponseEntity.ok(equipmentStateHistoryService.findByEquipmentStateId(stateId));
    }

    @PostMapping("/saveEquipmentStateHistory")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EquipmentStateHistory> saveEquipmentStateHistory(@RequestBody @Valid EquipmentStateHistoryPostRequestBody equipmentStateHistoryPostRequestBody){
        return new ResponseEntity<>(equipmentStateHistoryService.saveEquipmentStateHistory(equipmentStateHistoryPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipmentStateHistory")
    private ResponseEntity<Void> deleteEquipmentStateHistoryById(@RequestBody @Valid EquipmentStateHistoryId id){
        equipmentStateHistoryService.deleteEquipmentStateHistoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipmentStateHistory")
    private ResponseEntity<EquipmentStateHistory> replaceEquipment(@RequestBody @Valid EquipmentStateHistoryPutRequestBody equipmentStateHistoryPutRequestBody){
        return new ResponseEntity<>(equipmentStateHistoryService.replaceEquipmentStateHistory(equipmentStateHistoryPutRequestBody), HttpStatus.CREATED);
    }

}
