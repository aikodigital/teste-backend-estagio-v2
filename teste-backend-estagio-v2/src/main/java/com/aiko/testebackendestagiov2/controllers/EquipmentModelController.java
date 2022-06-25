package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentModelRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentModelCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentModel")
@RequiredArgsConstructor
public class EquipmentModelController {

    private final EquipmentModelCrudService equipmentModelCrudService;

    @GetMapping
    public List<EquipmentModel> getAll(){
        return equipmentModelCrudService.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentModel getById(@PathVariable UUID id){
        return equipmentModelCrudService.getById(id);
    }

    @PostMapping
    public EquipmentModel create(@RequestBody EquipmentModelRequest request){
        return equipmentModelCrudService.create(request);
    }

    @PutMapping("/{id}")
    public EquipmentModel update(@PathVariable UUID id, @RequestBody EquipmentModelRequest request){
        return equipmentModelCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentModelCrudService.delete(id);
    }

}
