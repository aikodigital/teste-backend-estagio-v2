package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentResponse;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentDtoConversionService;
import com.aiko.testebackendestagiov2.services.ImplCrud.EquipmentCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentCrudService equipmentCrudService;

    private final EquipmentDtoConversionService equipmentDtoConversionService;

    @GetMapping
    public List<EquipmentResponse> getAll(){
        List<Equipment> equipmentList = equipmentCrudService.getAll();
        return equipmentDtoConversionService.toEquipmentListResponse(equipmentList);
    }

    @GetMapping("/{id}")
    public EquipmentResponse getById(@PathVariable UUID id){
        Equipment equipment = equipmentCrudService.getById(id);
        return equipmentDtoConversionService.toEquipmentResponse(equipment);
    }

    @PostMapping
    public EquipmentResponse create(@RequestBody EquipmentRequest request){
        return equipmentDtoConversionService.toEquipmentResponse(equipmentCrudService.create(request));
    }

    @PutMapping("/{id}")
    public EquipmentResponse update(@PathVariable UUID id, @RequestBody EquipmentRequest request){
        return equipmentDtoConversionService.toEquipmentResponse(equipmentCrudService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentCrudService.delete(id);
    }

}
