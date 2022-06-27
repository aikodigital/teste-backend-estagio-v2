package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.EquipmentPositionHistory;
import com.brunozarth.testeaiko.model.EquipmentPositionHistoryId;
import com.brunozarth.testeaiko.requests.equipmentPositionHistory.EquipmentPositionHistoryPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentPositionHistory.EquipmentPositionHistoryPutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentPositionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipmentPositionHistory")
public class EquipmentPositionHistoryController {

    private final EquipmentPositionHistoryService equipmentPositionHistoryService;

    @Autowired
    public EquipmentPositionHistoryController(EquipmentPositionHistoryService equipmentPositionHistoryService){
        this.equipmentPositionHistoryService = equipmentPositionHistoryService;
    }

    @GetMapping
    private ResponseEntity<List<EquipmentPositionHistory>> equipmentPositionHistoryList(){
        return ResponseEntity.ok(equipmentPositionHistoryService.findAll());
    }

    @GetMapping("/findByEquipmentId/{equipmentId}")
    private ResponseEntity<List<EquipmentPositionHistory>> findByEquipmentModelId(@PathVariable UUID equipmentId){
        return ResponseEntity.ok(equipmentPositionHistoryService.findByEquipmentId(equipmentId));
    }

    @PostMapping("/saveEquipmentPositionHistory")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EquipmentPositionHistory> saveEquipmentPositionHistory(@RequestBody @Valid EquipmentPositionHistoryPostRequestBody equipmentPositionHistoryPostRequestBody){
        return new ResponseEntity<>(equipmentPositionHistoryService.saveEquipmentPositionHistory(equipmentPositionHistoryPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipmentPositionHistory")
    private ResponseEntity<Void> deleteEquipmentPositionHistoryById(@RequestBody @Valid EquipmentPositionHistoryId id){
        equipmentPositionHistoryService.deleteEquipmentPositionHistoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipmentPositionHistory")
    private ResponseEntity<EquipmentPositionHistory> replaceEquipment(@RequestBody @Valid EquipmentPositionHistoryPutRequestBody equipmentPositionHistoryPutRequestBody){
        return new ResponseEntity<>(equipmentPositionHistoryService.replaceEquipmentPositionHistory(equipmentPositionHistoryPutRequestBody), HttpStatus.CREATED);
    }

}
