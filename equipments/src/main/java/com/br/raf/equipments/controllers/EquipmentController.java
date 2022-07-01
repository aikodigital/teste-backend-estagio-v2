package com.br.raf.equipments.controllers;

import com.br.raf.equipments.entities.Equipment;
import com.br.raf.equipments.services.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAll(){
        return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody Equipment equipment){
        Equipment obj = equipmentService.save(equipment);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")UUID id){
        Optional<Equipment> optionalEquipment = equipmentService.findById(id);
        equipmentService.delete(optionalEquipment.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable(value = "id")UUID id, @RequestBody Equipment equipment){
        Optional<Equipment> optionalEquipment = equipmentService.findById(id);
        if(!optionalEquipment.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment not found");
        }

        equipment.setId(optionalEquipment.get().getId());
        equipment.setName(equipment.getName());
        equipment.setEquipmentModelId(equipment.getEquipmentModelId());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.save(equipment));
    }
}
