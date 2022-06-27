package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.EquipmentPositionHistoryRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentPositionHistoryResponse;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentPositionHistoryDTOConversionService;
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

    private final EquipmentPositionHistoryDTOConversionService equipmentPositionHistoryDTOConversionService;

    @GetMapping
    public List<EquipmentPositionHistoryResponse> getAll(){
        return equipmentPositionHistoryDTOConversionService.toDtoList(equipmentPositionHistoryCrudService.getAll());
    }

    @GetMapping("/{id}")
    public EquipmentPositionHistoryResponse getById(@PathVariable UUID id){
        return equipmentPositionHistoryDTOConversionService.toDto(equipmentPositionHistoryCrudService.getById(id));
    }

    @PostMapping
    public EquipmentPositionHistoryResponse create(@RequestBody EquipmentPositionHistoryRequest request){
        return equipmentPositionHistoryDTOConversionService.toDto(equipmentPositionHistoryCrudService.create(request));
    }

    @PutMapping("/{id}")
    public EquipmentPositionHistoryResponse update(@PathVariable UUID id, @RequestBody EquipmentPositionHistoryRequest request){
        return equipmentPositionHistoryDTOConversionService.toDto(equipmentPositionHistoryCrudService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentPositionHistoryCrudService.delete(id);
    }

}
