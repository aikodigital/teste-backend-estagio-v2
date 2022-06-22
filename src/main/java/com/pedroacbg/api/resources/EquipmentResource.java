package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/equipments")
public class EquipmentResource {

    @Autowired
    private EquipmentService service;

    @GetMapping
    public ResponseEntity<List<Equipment>> findAll(){
        List<Equipment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipment> findById(@PathVariable UUID id){
        Equipment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Equipment> insert(@RequestBody Equipment obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(obj));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Equipment obj){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
