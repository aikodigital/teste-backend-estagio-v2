package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentStateRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentStateResponse;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentStateDtoConversionService;
import com.aiko.testebackendestagiov2.services.ImplCrud.EquipmentStateCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentState")
@RequiredArgsConstructor
public class EquipmentStateController {

    private final EquipmentStateCrudService equipmentStateCrudService;

    private final EquipmentStateDtoConversionService equipmentStateDtoConversionService;

    @GetMapping
    public List<EquipmentStateResponse> getAll(){
        return equipmentStateDtoConversionService.toDtoList(equipmentStateCrudService.getAll());
    }

    @GetMapping("/{id}")
    public EquipmentStateResponse getById(@PathVariable UUID id){
        return equipmentStateDtoConversionService.toDto(equipmentStateCrudService.getById(id));
    }

    @PostMapping
    public EquipmentStateResponse create(@Valid @RequestBody EquipmentStateRequest request){
        return equipmentStateDtoConversionService.toDto(equipmentStateCrudService.create(request));
    }

    @PutMapping("/{id}")
    public EquipmentStateResponse update(@PathVariable UUID id,@Valid @RequestBody EquipmentStateRequest request){
        return equipmentStateDtoConversionService.toDto(equipmentStateCrudService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentStateCrudService.delete(id);
    }

}
