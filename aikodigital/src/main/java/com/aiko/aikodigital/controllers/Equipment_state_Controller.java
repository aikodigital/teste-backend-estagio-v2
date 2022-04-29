package com.aiko.aikodigital.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.aiko.aikodigital.enties.Equipment_model_state_hourly_earnings;
import com.aiko.aikodigital.enties.Equipment_state;
import com.aiko.aikodigital.repositoriesandservices.Equipment_state_service;

@RestController
@RequestMapping ("/api/equipamentos/")
public class Equipment_state_Controller {
	
	@Autowired
	private Equipment_state_service servico;
	
	@PostMapping
	private ResponseEntity<Equipment_state> guardar (@RequestBody Equipment_state Equipment_state){
		Equipment_state em = servico.create(Equipment_state);
		
		try {
			return ResponseEntity.created(new URI("/api/Equipment_state"+em.getId())).body(em);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Equipment_state>> entity (){
		return ResponseEntity.ok(servico.getAllEm());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deletar (@RequestBody Equipment_state em){
		servico.delete(em);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Equipment_state> editar(@RequestBody Equipment_state em) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.create(em));
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Equipment_state>> listarId (@PathVariable ("id") UUID id){
		return ResponseEntity.ok(servico.findById(id));
	}
	

}
