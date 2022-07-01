package com.br.raf.equipments.controllers;

import com.br.raf.equipments.entities.EquipmentModelStateHourlyEarnings;
import com.br.raf.equipments.services.EquipmentModelStateHourlyEarningsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipmentmodelstatehourlyearnings")
public class EquipmentModelStateHourlyEarningsController {
    private final EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;

    public EquipmentModelStateHourlyEarningsController(EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService) {
        this.equipmentModelStateHourlyEarningsService = equipmentModelStateHourlyEarningsService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> getAll(){
        return new ResponseEntity<>(equipmentModelStateHourlyEarningsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        EquipmentModelStateHourlyEarnings obj = equipmentModelStateHourlyEarningsService.save(equipmentModelStateHourlyEarnings);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{value}")
    public ResponseEntity<Object> delete(@PathVariable(value = "value")Integer value){
        var obj = equipmentModelStateHourlyEarningsService.findByValue(value);
        equipmentModelStateHourlyEarningsService.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment Model State deleted successfully.");
    }

    @PutMapping("/{value}")
    public ResponseEntity<Object> updateEquipmentModelState(@PathVariable(value = "value")Integer value,
                                                            @RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipmentModelStateHourlyEarnings =
                Optional.ofNullable(equipmentModelStateHourlyEarningsService.findByValue(value));
        if(!optionalEquipmentModelStateHourlyEarnings.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Model State not found");
        }

        equipmentModelStateHourlyEarnings.setEquipmentModelId(optionalEquipmentModelStateHourlyEarnings.get().getEquipmentModelId());
        equipmentModelStateHourlyEarnings.setEquipmentStateId(equipmentModelStateHourlyEarnings.getEquipmentStateId());
        equipmentModelStateHourlyEarnings.setValue(equipmentModelStateHourlyEarnings.getValue());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelStateHourlyEarningsService.save(equipmentModelStateHourlyEarnings));
    }
}
