package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentState;
import com.pedroacbg.api.services.EquipmentStateService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/equipment/state")
public class EquipmentStateResource {

    @Autowired
    private EquipmentStateService service;

    @GetMapping
    public ResponseEntity<List<EquipmentState>> findAll(){
        List<EquipmentState> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentState> findById(@PathVariable UUID id){
        EquipmentState obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<EquipmentState> insert(@RequestBody EquipmentState obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(obj));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EquipmentState> update(@PathVariable UUID id, @RequestBody EquipmentState obj){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
