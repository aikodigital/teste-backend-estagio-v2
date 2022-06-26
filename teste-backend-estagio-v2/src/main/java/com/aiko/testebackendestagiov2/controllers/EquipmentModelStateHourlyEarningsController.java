package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentModelStateHourlyEarningsRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.services.Impl.EquipmentModelStateHourlyEarningsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentModelStateHourlyEarnings")
@RequiredArgsConstructor
public class EquipmentModelStateHourlyEarningsController {

    private final EquipmentModelStateHourlyEarningsCrudService equipmentModelStateHourlyEarningsCrudService;

    @GetMapping
    public List<EquipmentModelStateHourlyEarnings> getAll(){
        return equipmentModelStateHourlyEarningsCrudService.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentModelStateHourlyEarnings getById(@PathVariable UUID id){
        return equipmentModelStateHourlyEarningsCrudService.getById(id);
    }

    @PostMapping
    public EquipmentModelStateHourlyEarnings create(@RequestBody EquipmentModelStateHourlyEarningsRequest request){
        return equipmentModelStateHourlyEarningsCrudService.create(request);
    }

    @PutMapping("/{id}")
    public EquipmentModelStateHourlyEarnings update(@PathVariable UUID id, @RequestBody EquipmentModelStateHourlyEarningsRequest request){
        return equipmentModelStateHourlyEarningsCrudService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentModelStateHourlyEarningsCrudService.delete(id);
    }

}
