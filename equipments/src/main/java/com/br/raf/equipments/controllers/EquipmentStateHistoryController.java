package com.br.raf.equipments.controllers;

import com.br.raf.equipments.entities.EquipmentStateHistory;
import com.br.raf.equipments.services.EquipmentStateHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/equipmentstatehistory")
public class EquipmentStateHistoryController {
    private final EquipmentStateHistoryService equipmentStateHistoryService;

    public EquipmentStateHistoryController(EquipmentStateHistoryService equipmentStateHistoryService) {
        this.equipmentStateHistoryService = equipmentStateHistoryService;
    }

    @GetMapping
    public ResponseEntity<Set<EquipmentStateHistory>> getAll(){
        return new ResponseEntity<>(equipmentStateHistoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public Optional<EquipmentStateHistory> findByDate(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime){
        return Optional.ofNullable(equipmentStateHistoryService.findByDate(dateTime));
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody EquipmentStateHistory equipmentStateHistory){
        EquipmentStateHistory obj = equipmentStateHistoryService.save(equipmentStateHistory);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<Object> delete(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime){
        var obj = equipmentStateHistoryService.findByDate(dateTime);
        equipmentStateHistoryService.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment State History deleted successfully.");
    }

    @PutMapping("/{date}")
    public ResponseEntity<Object> updateEquipmentModel(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime dateTime,
                                                       @RequestBody EquipmentStateHistory equipmentStateHistory){
        var obj = equipmentStateHistoryService.findByDate(dateTime);
        if(!obj.equals(equipmentStateHistory.getDate())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment State history not found");
        }

        equipmentStateHistory.setEquipmentStateId(equipmentStateHistory.getEquipmentStateId());
        equipmentStateHistory.setEquipmentId(equipmentStateHistory.getEquipmentId());
        equipmentStateHistory.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentStateHistoryService.save(equipmentStateHistory));
    }
}
