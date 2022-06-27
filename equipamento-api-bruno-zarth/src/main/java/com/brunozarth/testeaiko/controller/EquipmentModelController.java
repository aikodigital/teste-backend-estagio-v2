package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.EquipmentModel;
import com.brunozarth.testeaiko.requests.equipmentModel.EquipmentModelPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentModel.EquipmentModelPutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipmentModel")
public class EquipmentModelController {

    private final EquipmentModelService equipmentModelService;

    @Autowired
    public EquipmentModelController(EquipmentModelService equipmentModelService){
        this.equipmentModelService = equipmentModelService;
    }

    @GetMapping
    private ResponseEntity<List<EquipmentModel>> equipmentModelList(){
        return ResponseEntity.ok(equipmentModelService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<EquipmentModel> findById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentModelService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/name")
    private ResponseEntity<List<EquipmentModel>> findByName(@RequestParam String name){
        return ResponseEntity.ok(equipmentModelService.findByName(name));
    }

    @PostMapping("/saveEquipmentModel")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EquipmentModel> saveEquipmentModel(@RequestBody @Valid EquipmentModelPostRequestBody equipmentModelPostRequestBody){
        return new ResponseEntity<>(equipmentModelService.saveEquipmentModel(equipmentModelPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipmentModel/{id}")
    private ResponseEntity<Void> deleteEquipmentModelById(@PathVariable UUID id){
        equipmentModelService.deleteEquipmentModelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipmentModel")
    private ResponseEntity<EquipmentModel> replaceEquipment(@RequestBody @Valid EquipmentModelPutRequestBody equipmentModelPutRequestBody){
        return new ResponseEntity<>(equipmentModelService.replaceEquipmentModel(equipmentModelPutRequestBody), HttpStatus.CREATED);
    }

}
