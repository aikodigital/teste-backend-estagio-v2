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
import com.aiko.aikodigital.enties.Equipment_position_history;
import com.aiko.aikodigital.repositoriesandservices.Equipment_position_history_service;

@RestController
@RequestMapping ("/api/Equipment_position_history/")
public class Equipment_position_history_Controller {
	
	@Autowired
	private Equipment_position_history_service servico;
	
	@PostMapping
	private ResponseEntity<Equipment_position_history> guardar (@RequestBody Equipment_position_history Equipment_position_history){
		Equipment_position_history em = servico.create(Equipment_position_history);
		
		try {
			return ResponseEntity.created(new URI("/api/Equipment_position_history"+em.getLat())).body(em);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Equipment_position_history>> listar (){
		return ResponseEntity.ok(servico.list());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deletar (@RequestBody Equipment_position_history em){
		servico.delete(em);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Equipment_position_history> editar(@RequestBody Equipment_position_history em) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.create(em));
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Equipment_position_history>> listarId (@PathVariable ("id") UUID id){
		return ResponseEntity.ok(servico.findById(id));
	}

}
