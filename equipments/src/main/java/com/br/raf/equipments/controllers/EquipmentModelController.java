package com.br.raf.equipments.controllers;


import com.br.raf.equipments.entities.EquipmentModel;
import com.br.raf.equipments.services.EquipmentModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentmodel")
public class EquipmentModelController {
    private final EquipmentModelService equipmentModelService;

    public EquipmentModelController(EquipmentModelService equipmentModelService) {
        this.equipmentModelService = equipmentModelService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentModel>> getAll(){
        return new ResponseEntity<>(equipmentModelService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody EquipmentModel equipmentModel){
        EquipmentModel obj = equipmentModelService.save(equipmentModel);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        Optional<EquipmentModel> optionalEquipmentModel = equipmentModelService.findById(id);
        equipmentModelService.delete(optionalEquipmentModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment Model deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipmentModel(@PathVariable(value = "id")UUID id, @RequestBody EquipmentModel equipmentModel){
        Optional<EquipmentModel> optionalEquipmentModel = equipmentModelService.findById(id);
        if(!optionalEquipmentModel.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EquipmentModel not found");
        }

        equipmentModel.setId(optionalEquipmentModel.get().getId());
        equipmentModel.setName(equipmentModel.getName());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelService.save(equipmentModel));
    }
}
