package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentRequest;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentCrudService equipmentCrudService;

    @GetMapping
    public List<Equipment> getAll(){
        return equipmentCrudService.getAll();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable UUID id){
        return equipmentCrudService.getById(id);
    }

    @PostMapping
    public Equipment create(@RequestBody EquipmentRequest request){
        return equipmentCrudService.create(request);
    }

    @PutMapping("/{id}")
    public Equipment update(@PathVariable UUID id, @RequestBody EquipmentRequest request){
        return equipmentCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentCrudService.delete(id);
    }

}
