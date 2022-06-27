package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentModelStateHourlyEarningsRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentModelStateHourlyEarningsResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentModelStateHourlyEarningsDtoConversionService;
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

    private final EquipmentModelStateHourlyEarningsDtoConversionService equipmentModelStateHourlyEarningsDtoConversionService;

    @GetMapping
    public List<EquipmentModelStateHourlyEarningsResponse> getAll(){
        List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarningsList = equipmentModelStateHourlyEarningsCrudService.getAll();
        return equipmentModelStateHourlyEarningsDtoConversionService.toDtoList(equipmentModelStateHourlyEarningsList);
    }

    @GetMapping("/{id}")
    public EquipmentModelStateHourlyEarningsResponse getById(@PathVariable UUID id){
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsCrudService.getById(id);
        return equipmentModelStateHourlyEarningsDtoConversionService.toDto(equipmentModelStateHourlyEarnings);
    }

    @PostMapping
    public EquipmentModelStateHourlyEarningsResponse create(@RequestBody EquipmentModelStateHourlyEarningsRequest request){
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsCrudService.create(request);
        return equipmentModelStateHourlyEarningsDtoConversionService.toDto(equipmentModelStateHourlyEarnings);
    }

    @PutMapping("/{id}")
    public EquipmentModelStateHourlyEarningsResponse update(@PathVariable UUID id, @RequestBody EquipmentModelStateHourlyEarningsRequest request){
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsCrudService.update(id, request);
        return equipmentModelStateHourlyEarningsDtoConversionService.toDto(equipmentModelStateHourlyEarnings);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentModelStateHourlyEarningsCrudService.delete(id);
    }

}
