package com.br.raf.equipments.controllers;

import com.br.raf.equipments.entities.EquipmentState;
import com.br.raf.equipments.services.EquipmentStateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentstate")
public class EquipmentStateController {

    private final EquipmentStateService equipmentStateService;

    public EquipmentStateController(EquipmentStateService equipmentStateService) {
        this.equipmentStateService = equipmentStateService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentState>> getAll(){
        return new ResponseEntity<>(equipmentStateService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentState> createEquipmentState(@RequestBody EquipmentState equipmentState){
        var obj = equipmentStateService.save(equipmentState);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        Optional<EquipmentState> optionalEquipmentState = equipmentStateService.findById(id);
        equipmentStateService.delete(optionalEquipmentState.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment State deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable(value = "id")UUID id, @RequestBody EquipmentState equipmentState){
        Optional<EquipmentState> optionalEquipmentState = equipmentStateService.findById(id);
        if(!optionalEquipmentState.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment not found");
        }
        equipmentState.setId(optionalEquipmentState.get().getId());
        equipmentState.setName(equipmentState.getName());
        equipmentState.setColor(equipmentState.getColor());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentStateService.save(equipmentState));
    }
}
