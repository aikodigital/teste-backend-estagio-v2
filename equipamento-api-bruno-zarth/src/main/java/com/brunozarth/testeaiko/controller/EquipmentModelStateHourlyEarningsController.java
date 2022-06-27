package com.brunozarth.testeaiko.controller;

import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarnings;
import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarningsId;
import com.brunozarth.testeaiko.requests.equipmentModelStateHourlyEarnings.EquipmentModelStateHourlyEarningsPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentModelStateHourlyEarnings.EquipmentModelStateHourlyEarningsPutRequestBody;
import com.brunozarth.testeaiko.service.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipmentModelStateHourlyEarnings")
public class EquipmentModelStateHourlyEarningsController {

    private final EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;

    @Autowired
    public EquipmentModelStateHourlyEarningsController(EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService){
        this.equipmentModelStateHourlyEarningsService = equipmentModelStateHourlyEarningsService;
    }

    @GetMapping
    private ResponseEntity<List<EquipmentModelStateHourlyEarnings>> equipmentModelStateHourlyEarningsList(){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.findAll());
    }

    @GetMapping("/findByModelId/{modelId}")
    private ResponseEntity<List<EquipmentModelStateHourlyEarnings>> findByEquipmentModelId(@PathVariable UUID modelId){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.findByEquipmentModelId(modelId));
    }

    @GetMapping("/findByStateId/{stateId}")
    private ResponseEntity<List<EquipmentModelStateHourlyEarnings>> findByEquipmentStateId(@PathVariable UUID stateId){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.findByEquipmentStateId(stateId));
    }

    @PostMapping("/saveEquipmentModelStateHourlyEarnings")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EquipmentModelStateHourlyEarnings> saveEquipmentModelStateHourlyEarnings(@RequestBody @Valid EquipmentModelStateHourlyEarningsPostRequestBody equipmentModelStateHourlyEarningsPostRequestBody){
        return new ResponseEntity<>(equipmentModelStateHourlyEarningsService.saveEquipmentModelStateHourlyEarnings(equipmentModelStateHourlyEarningsPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEquipmentModelStateHourlyEarnings")
    private ResponseEntity<Void> deleteEquipmentModelStateHourlyEarningsById(@RequestBody @Valid EquipmentModelStateHourlyEarningsId id){
        equipmentModelStateHourlyEarningsService.deleteEquipmentModelStateHourlyEarningsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replaceEquipmentModelStateHourlyEarnings")
    private ResponseEntity<EquipmentModelStateHourlyEarnings> replaceEquipment(@RequestBody @Valid EquipmentModelStateHourlyEarningsPutRequestBody equipmentModelStateHourlyEarningsPutRequestBody){
        return new ResponseEntity<>(equipmentModelStateHourlyEarningsService.replaceEquipmentModelStateHourlyEarnings(equipmentModelStateHourlyEarningsPutRequestBody), HttpStatus.CREATED);
    }

}
