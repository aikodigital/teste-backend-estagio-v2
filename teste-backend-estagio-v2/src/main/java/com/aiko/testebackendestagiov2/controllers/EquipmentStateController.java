package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentStateRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentStateCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentState")
@RequiredArgsConstructor
public class EquipmentStateController {

    private final EquipmentStateCrudService equipmentStateCrudService;

    @GetMapping
    public List<EquipmentState> getAll(){
        return equipmentStateCrudService.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentState getById(@PathVariable UUID id){
        return equipmentStateCrudService.getById(id);
    }

    @PostMapping
    public EquipmentState create(@RequestBody EquipmentStateRequest request){
        return equipmentStateCrudService.create(request);
    }

    @PutMapping("/{id}")
    public EquipmentState update(@PathVariable UUID id, @RequestBody EquipmentStateRequest request){
        return equipmentStateCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentStateCrudService.delete(id);
    }

}
