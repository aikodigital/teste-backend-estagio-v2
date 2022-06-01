package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentState;
import com.aiko.testebackendestagiov2.services.EquipmentStateService;

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


@RestController @RequestMapping(value = "/api/states")
public class EquipmentStateController {
 
    private EquipmentStateService stateService;

    public EquipmentStateController(EquipmentStateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentState>> findAllStates(){
        return ResponseEntity.ok().body(stateService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentState> findStateById(@PathVariable UUID id){
        EquipmentState foundState = stateService.findById(id);
        if(foundState == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(foundState);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<EquipmentState> saveState(@RequestBody EquipmentState obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(obj));
    }

    @PutMapping(value="update/{id}")
    public ResponseEntity<EquipmentState> updateState(@PathVariable UUID id, @RequestBody EquipmentState obj) {
        return ResponseEntity.ok().body(stateService.update(id, obj));
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteStateById(@PathVariable UUID id){
        stateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}