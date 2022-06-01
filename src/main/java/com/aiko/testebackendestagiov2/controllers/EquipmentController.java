package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.services.EquipmentService;

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

@RestController @RequestMapping(value = "/api/equipments")
public class EquipmentController {
 
    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> findAllEquipments(){
        return ResponseEntity.ok().body(equipmentService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipment> findEquipmentById(@PathVariable UUID id){
        Equipment foundEquipment = equipmentService.findById(id);
        if(foundEquipment == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(foundEquipment);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Equipment> saveEquipment(@RequestBody Equipment equipment){
        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentService.save(equipment));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable UUID id, @RequestBody Equipment equipment){
        return ResponseEntity.ok().body(equipmentService.update(id, equipment));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteEquipmentById(@PathVariable UUID id){
        equipmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}