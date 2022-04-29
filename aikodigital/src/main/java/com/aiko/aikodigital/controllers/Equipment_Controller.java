package com.aiko.aikodigital.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Collections;
import java.util.Comparator;

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

import com.aiko.aikodigital.enties.Equipment;
import com.aiko.aikodigital.enties.Equipment_position_history;
import com.aiko.aikodigital.enties.Equipment_state_history;
import com.aiko.aikodigital.repositoriesandservices.Equipment_position_history_service;
import com.aiko.aikodigital.repositoriesandservices.Equipment_service;
import com.aiko.aikodigital.repositoriesandservices.Equipment_state_history_service;

@RestController
@RequestMapping ("/api/equipamentos/")
public class Equipment_Controller {
	
	@Autowired
	private Equipment_service servico;
	private  Equipment_state_history_service servico_states;
	private  Equipment_position_history_service servico_position;
	
	
	@GetMapping("/equipments/recent_states")
	public ResponseEntity<List<Equipment_state_history>> recent_states() {
		
		List<Equipment_state_history> lista = servico_states.list();
		Comparator<Equipment_state_history> recents = (data1, data2) -> { 
			return data1.getDate().compareTo(data2.getDate());  
		};
				
		    Collections.sort(lista, recents);	 	

			return ResponseEntity.status(HttpStatus.OK).body(lista);	
		
	}
	
	
	@GetMapping("/equipments/recent_positions")
	public ResponseEntity<List<Equipment_position_history>> recent_positions() {
		
		List<Equipment_position_history> lista = servico_position.list();
		Comparator<Equipment_position_history> recents = (data1, data2) -> { 
			return data1.getDate().compareTo(data2.getDate());  
		};
				
		    Collections.sort(lista, recents);	 	

			return ResponseEntity.status(HttpStatus.OK).body(lista);	
		
	}
	
	
	@PostMapping
	private ResponseEntity<Equipment> guardar (@RequestBody Equipment modelo){
		Equipment em = servico.create(modelo);
		
		try {
			return ResponseEntity.created(new URI("/api/equipamentos"+em.getId())).body(em);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Equipment>> listar (){
		return ResponseEntity.ok(servico.getAllEm());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deletar (@RequestBody Equipment em){
		servico.delete(em);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Equipment> editar(@RequestBody Equipment em) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.create(em));
	}
	
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Equipment>> listarId (@PathVariable ("id") UUID id){
		return ResponseEntity.ok(servico.findById(id));
	}
	

}
