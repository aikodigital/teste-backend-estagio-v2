package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentStateHistoryRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentStateHistoryResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentStateHistoryDtoConversionService;
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

    private final EquipmentStateHistoryDtoConversionService equipmentStateHistoryDtoConversionService;

    @GetMapping
    public List<EquipmentStateHistoryResponse> getAll(){
        return equipmentStateHistoryDtoConversionService.toDtoList(
                equipmentStateHistoryCrudService.getAll());
    }

    @GetMapping("/{id}")
    public EquipmentStateHistoryResponse getById(@PathVariable UUID id){
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryCrudService.getById(id);
        return equipmentStateHistoryDtoConversionService.toDto(equipmentStateHistory);
    }

    @PostMapping
    public EquipmentStateHistoryResponse create(@RequestBody EquipmentStateHistoryRequest request){
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryCrudService.create(request);
        return equipmentStateHistoryDtoConversionService.toDto(equipmentStateHistory);
    }

    @PutMapping("/{id}")
    public EquipmentStateHistoryResponse update(@PathVariable UUID id, @RequestBody EquipmentStateHistoryRequest request){
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryCrudService.update(id, request);
        return equipmentStateHistoryDtoConversionService.toDto(equipmentStateHistory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentStateHistoryCrudService.delete(id);
    }
}
