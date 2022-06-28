package digital.aiko.teste.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import digital.aiko.teste.model.entities.EquipmentPositionHistory;
import digital.aiko.teste.model.services.EquipmentPositionHistoryServices;

@RestController
@RequestMapping(path = "/equiment-position-history")
public class EquipmentPositionHistoryController {

	private EquipmentPositionHistoryServices service;
	
	
	
	public EquipmentPositionHistoryController(EquipmentPositionHistoryServices service) {
		this.service = service;
	}


	@PostMapping
	public @ResponseBody EquipmentPositionHistory save(@RequestBody EquipmentPositionHistory equipmentPositionHistory) {
		return this.service.save(equipmentPositionHistory);
		
	} 

	@GetMapping(path = "/{id}") 
	public Optional<EquipmentPositionHistory> findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	
	@GetMapping
	public ResponseEntity<Iterable<EquipmentPositionHistory>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}
}

