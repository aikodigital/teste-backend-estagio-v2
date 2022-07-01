package com.br.raf.equipments.controllers;

import com.br.raf.equipments.entities.EquipmentPositionHistory;
import com.br.raf.equipments.services.EquipmentPositionHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/equipmentpositionhistory")
public class EquipmentPositionHistoryController {
    private final EquipmentPositionHistoryService equipmentPositionHistoryService;

    public EquipmentPositionHistoryController(EquipmentPositionHistoryService equipmentPositionHistoryService) {
        this.equipmentPositionHistoryService = equipmentPositionHistoryService;
    }

    @GetMapping
    public ResponseEntity<Set<EquipmentPositionHistory>> getAll(){
        return new ResponseEntity<>(equipmentPositionHistoryService.getAll(), HttpStatus.OK);
    }

    /*@GetMapping("/{date}")
    public Optional<EquipmentPositionHistory> findByDate(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime){
        return Optional.ofNullable(equipmentPositionHistoryService.findByDate(dateTime));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<List<EquipmentPositionHistory>> findById(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(equipmentPositionHistoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody EquipmentPositionHistory equipmentPositionHistory){
        EquipmentPositionHistory obj = equipmentPositionHistoryService.save(equipmentPositionHistory);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<Object> delete(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime){
        var obj = equipmentPositionHistoryService.findByDate(dateTime);
        equipmentPositionHistoryService.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment Position History deleted successfully.");
    }

    @PutMapping("/{date}")
    public ResponseEntity<Object> updateEquipmentModel(@PathVariable(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime dateTime,
                                                       @RequestBody EquipmentPositionHistory equipmentPositionHistory){
        var obj = equipmentPositionHistoryService.findByDate(dateTime);
        if(!obj.getDate().isEqual(equipmentPositionHistory.getDate())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment position History not found");
        }

        equipmentPositionHistory.setEquipmentId(obj.getEquipmentId());
        equipmentPositionHistory.setDate(LocalDateTime.now());
        equipmentPositionHistory.setLat(equipmentPositionHistory.getLat());
        equipmentPositionHistory.setLon(equipmentPositionHistory.getLon());
        return ResponseEntity.status(HttpStatus.OK).body(equipmentPositionHistoryService.save(equipmentPositionHistory));
    }
}
