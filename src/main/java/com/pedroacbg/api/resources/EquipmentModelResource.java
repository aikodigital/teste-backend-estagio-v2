package com.pedroacbg.api.resources;

import com.pedroacbg.api.entities.EquipmentModel;
import com.pedroacbg.api.services.EquipmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/equipments/models")
public class EquipmentModelResource {

    @Autowired
    private EquipmentModelService service;

    @GetMapping
    public ResponseEntity<List<EquipmentModel>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentModel> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(service.findById(id));
    }


    @PostMapping
    public ResponseEntity<EquipmentModel> insert(EquipmentModel obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(obj));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EquipmentModel> update(@PathVariable UUID id, @RequestBody EquipmentModel obj){
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
