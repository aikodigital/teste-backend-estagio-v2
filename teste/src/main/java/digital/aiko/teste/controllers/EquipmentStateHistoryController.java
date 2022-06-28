package digital.aiko.teste.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import digital.aiko.teste.model.entities.EquipmentStateHistory;
import digital.aiko.teste.model.services.EquipmentStateHistoryServices;

@RestController
@RequestMapping(path = "/equipment-state-history")
public class EquipmentStateHistoryController {

	private EquipmentStateHistoryServices service;

	public EquipmentStateHistoryController(EquipmentStateHistoryServices service) {
		this.service = service;
	}

	@PostMapping
	public @ResponseBody EquipmentStateHistory save(@RequestBody EquipmentStateHistory equipmentStateHistory) {
		this.service.save(equipmentStateHistory);
		return equipmentStateHistory;

	}	

	@PutMapping
	public EquipmentStateHistory update(@RequestBody EquipmentStateHistory equipmentStateHistory) {
		return this.service.save(equipmentStateHistory);

	}


	@GetMapping(path = "/equipment_id/{id}/{id2}")
	public Iterable<EquipmentStateHistory> searchByIdLike(@PathVariable String id, @PathVariable String id2) {
		return service.searchByIdLike(id, id2);
	}

	@GetMapping
	public ResponseEntity<Iterable<EquipmentStateHistory>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}


}


