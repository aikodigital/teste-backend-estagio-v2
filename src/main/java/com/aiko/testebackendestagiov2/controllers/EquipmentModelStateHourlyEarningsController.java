package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.services.EquipmentModelStateHourlyEarningsService;

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

@RestController @RequestMapping(value = "/api/earnings")
public class EquipmentModelStateHourlyEarningsController {
    
    private EquipmentModelStateHourlyEarningsService earningsService;

    public EquipmentModelStateHourlyEarningsController(EquipmentModelStateHourlyEarningsService earningsService) {
        this.earningsService = earningsService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> findAllEarnings(){
        return ResponseEntity.ok().body(earningsService.findAll());
    }

    @GetMapping(value = "/{modelId}/{stateId}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> findEarningById(@PathVariable UUID modelId, @PathVariable UUID stateId){
        EquipmentModelStateHourlyEarnings foundEarning = earningsService.findById(modelId, stateId);
        if(foundEarning == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(foundEarning);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> saveEarning(@RequestBody EquipmentModelStateHourlyEarnings hourlyEarnings){
        EquipmentModelStateHourlyEarnings savedEarning = earningsService.save(hourlyEarnings);
        if (savedEarning == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEarning);
        }
    }

    @PutMapping(value = "/update/{modelId}/{stateId}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> updateEarning(@PathVariable UUID modelId,
            @PathVariable UUID stateId, @RequestBody EquipmentModelStateHourlyEarnings hourlyEarnings) {
        return ResponseEntity.ok().body(earningsService.update(modelId, stateId, hourlyEarnings));
    }

    @DeleteMapping(value = "/delete/{modelId}/{stateId}")
    public ResponseEntity<Void> deleteEarningById(@PathVariable UUID modelId, @PathVariable UUID stateId){
        earningsService.deleteById(modelId, stateId);
        return ResponseEntity.noContent().build();
    }

}