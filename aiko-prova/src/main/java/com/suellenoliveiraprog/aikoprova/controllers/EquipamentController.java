package com.suellenoliveiraprog.aikoprova.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.Equipament;
import com.suellenoliveiraprog.aikoprova.services.EquipamentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/equipament")
public class EquipamentController {
    
    @Autowired
    private EquipamentServices equipamentServices;

    @GetMapping
    public ResponseEntity<List<Equipament>> consultarTodosEquipamentos(){
        
        List<Equipament> equipaments = equipamentServices.consultarTodosEquipamentos();
        return new ResponseEntity<>(equipaments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Equipament>> consultarEquipamentosPorID(@PathVariable UUID id){
        
        Optional<Equipament> equipaments = equipamentServices.consultarEquipamentosPorID(id);
        return new ResponseEntity<>(equipaments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Equipament> adicionarEquipamento(@RequestBody Equipament equipamentAdc){
        
        Equipament equipaments = equipamentServices.adicionarEquipamento(equipamentAdc);
        return new ResponseEntity<>(equipaments, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipament> atualizarEquipamento(@RequestBody Equipament equipamentAdc, @PathVariable UUID id){
        
        Equipament equipaments = equipamentServices.atualizarEquipamento(equipamentAdc, id);
        return new ResponseEntity<>(equipaments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable UUID id){
        
        equipamentServices.deletarEquipamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
