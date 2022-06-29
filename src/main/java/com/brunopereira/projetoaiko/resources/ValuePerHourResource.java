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

import com.brunopereira.projetoaiko.entities.ValuePerHour;
import com.brunopereira.projetoaiko.service.ValuePerHourService;

@RestController
@RequestMapping(value = "/values")
public class ValuePerHourResource {
	
	@Autowired
	private ValuePerHourService service;
	
	@GetMapping
	public ResponseEntity<List<ValuePerHour>> findAll() {
		List<ValuePerHour> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<ValuePerHour> findById(@PathVariable Long id) {
		ValuePerHour obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ValuePerHour insert(@RequestBody ValuePerHour obj){
		
		return service.insert(obj);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ValuePerHour> update(@PathVariable Long id, @RequestBody ValuePerHour obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
