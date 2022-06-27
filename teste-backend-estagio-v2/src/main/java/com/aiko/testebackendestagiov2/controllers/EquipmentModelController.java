package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentModelRequest;
import com.aiko.testebackendestagiov2.dtos.responses.EquipmentModelResponse;
import com.aiko.testebackendestagiov2.services.Conversions.EquipmentModelDtoConversioService;
import com.aiko.testebackendestagiov2.services.ImplCrud.EquipmentModelCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentModel")
@RequiredArgsConstructor
public class EquipmentModelController {

    private final EquipmentModelCrudService equipmentModelCrudService;

    private final EquipmentModelDtoConversioService equipmentModelDtoConversioService;

    @GetMapping
    public List<EquipmentModelResponse> getAll(){
        return equipmentModelDtoConversioService.toEquipmentModelListResponse(equipmentModelCrudService.getAll());
    }

    @GetMapping("/{id}")
    public EquipmentModelResponse getById(@PathVariable UUID id){

        return equipmentModelDtoConversioService.toEquipmentModelResponse(equipmentModelCrudService.getById(id));
    }

    @PostMapping
    public EquipmentModelResponse create(@Valid @RequestBody EquipmentModelRequest request){
        return equipmentModelDtoConversioService.toEquipmentModelResponse(equipmentModelCrudService.create(request));
    }

    @PutMapping("/{id}")
    public EquipmentModelResponse update(@PathVariable UUID id, @Valid @RequestBody EquipmentModelRequest request){
        return equipmentModelDtoConversioService.toEquipmentModelResponse(equipmentModelCrudService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        equipmentModelCrudService.delete(id);
    }

}
