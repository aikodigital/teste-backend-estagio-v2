package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentPositionHistoryRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentPositionHistoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentPositionHistory")
@RequiredArgsConstructor
public class EquipmentPositionHistoryController {

    private final EquipmentPositionHistoryCrudService equipmentPositionHistoryCrudService;

    @GetMapping
    public List<EquipmentPositionHistory> getAll(){
        return equipmentPositionHistoryCrudService.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentPositionHistory getById(@PathVariable UUID id){
        return equipmentPositionHistoryCrudService.getById(id);
    }

    @PostMapping
    public EquipmentPositionHistory create(@RequestBody EquipmentPositionHistoryRequest request){
        return equipmentPositionHistoryCrudService.create(request);
    }

    @PutMapping("/{id}")
    public EquipmentPositionHistory update(@PathVariable UUID id, @RequestBody EquipmentPositionHistoryRequest request){
        return equipmentPositionHistoryCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentPositionHistoryCrudService.delete(id);
    }

}
