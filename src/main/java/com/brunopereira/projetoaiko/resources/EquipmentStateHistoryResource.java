package com.brunopereira.projetoaiko.resources;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunopereira.projetoaiko.entities.EquipmentStateHistory;
import com.brunopereira.projetoaiko.service.EquipmentStateHistoryService;

@RestController
@RequestMapping(value = "history/states")
public class EquipmentStateHistoryResource {
	
	@Autowired
	private EquipmentStateHistoryService service;
	
	@GetMapping
	public ResponseEntity<List<EquipmentStateHistory>> findAll() {
		List<EquipmentStateHistory> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<EquipmentStateHistory> findById(@PathVariable Long id) {
		EquipmentStateHistory obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentStateHistory insert(@RequestBody EquipmentStateHistory obj){
		
		return service.insert(obj);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EquipmentStateHistory> update(@PathVariable Long id, @RequestBody EquipmentStateHistory obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}


}
