package com.suellenoliveiraprog.aikoprova.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.EquipamentModel;
import com.suellenoliveiraprog.aikoprova.services.EquipamentModelServices;
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
@RequestMapping("api/equipamentModel")
public class EquipamentModelController {
    
    @Autowired
    private EquipamentModelServices equipamentModelServices;

    @GetMapping
    public ResponseEntity<List<EquipamentModel>> consultarTodosModelosEquipamentos(){
        
        List<EquipamentModel> equipamentsModel = equipamentModelServices.consultarTodosModelosEquipamentos();
        return new ResponseEntity<>(equipamentsModel, HttpStatus.OK);
    }  

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EquipamentModel>> consultarEquipamentosPorID(@PathVariable UUID id){
        
        Optional<EquipamentModel> equipaments = equipamentModelServices.consultarEquipamentosPorID(id);
        return new ResponseEntity<>(equipaments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipamentModel> adicionarEquipamento(@RequestBody EquipamentModel equipamentAdc){
        
        EquipamentModel equipaments = equipamentModelServices.adicionarEquipamento(equipamentAdc);
        return new ResponseEntity<EquipamentModel>(equipaments, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentModel> atualizarEquipamento(@RequestBody EquipamentModel equipamentModelAtz, @PathVariable UUID id){
        
        EquipamentModel equipaments = equipamentModelServices.atualizarEquipamento(equipamentModelAtz, id);
        return new ResponseEntity<EquipamentModel>(equipaments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable UUID id){
        
        equipamentModelServices.deletarEquipamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
