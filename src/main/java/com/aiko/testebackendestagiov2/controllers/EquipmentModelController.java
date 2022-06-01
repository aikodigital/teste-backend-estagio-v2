package com.aiko.testebackendestagiov2.controllers;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentModel;
import com.aiko.testebackendestagiov2.services.EquipmentModelService;

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

@RestController @RequestMapping(value = "/api/models")
public class EquipmentModelController {
 
    private EquipmentModelService modelService;

    public EquipmentModelController(EquipmentModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentModel>> findAllModels(){
        return ResponseEntity.ok().body(modelService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentModel> findModelById(@PathVariable UUID id){
        EquipmentModel foundModel = modelService.findById(id);
        if(foundModel == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(foundModel);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<EquipmentModel> saveModel(@RequestBody EquipmentModel equipmentModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.save(equipmentModel));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<EquipmentModel> updateModel(@PathVariable UUID id, @RequestBody EquipmentModel equipmentModel){
        return ResponseEntity.ok().body(modelService.update(id, equipmentModel));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID id){
        modelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}