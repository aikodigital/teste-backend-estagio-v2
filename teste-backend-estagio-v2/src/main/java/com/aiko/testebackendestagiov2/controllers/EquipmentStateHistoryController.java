package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentStateHistoryRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentStateHistoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentStateHistory")
@RequiredArgsConstructor
public class EquipmentStateHistoryController {

    private final EquipmentStateHistoryCrudService equipmentStateHistoryCrudService;

    @GetMapping
    public List<EquipmentStateHistory> getAll(){
        return equipmentStateHistoryCrudService.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentStateHistory getById(@PathVariable UUID id){
        return equipmentStateHistoryCrudService.getById(id);
    }

    @PostMapping
    public EquipmentStateHistory create(@RequestBody EquipmentStateHistoryRequest request){
        return equipmentStateHistoryCrudService.create(request);
    }

    @PutMapping("/{id}")
    public EquipmentStateHistory update(@PathVariable UUID id, @RequestBody EquipmentStateHistoryRequest request){
        return equipmentStateHistoryCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentStateHistoryCrudService.delete(id);
    }
}
