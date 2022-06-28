package digital.aiko.teste.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import digital.aiko.teste.model.entities.EquipmentState;
import digital.aiko.teste.model.services.EquipmentStateServices;

@RestController
@RequestMapping(path = "/equipment-state")
public class EquipmentStateController {

	private EquipmentStateServices service;

	public EquipmentStateController(EquipmentStateServices service) {
		this.service = service;
	}

	@PostMapping
	public @ResponseBody EquipmentState save(@RequestBody EquipmentState equipmentState) {
		this.service.save(equipmentState);
		return equipmentState;

	}

	@PutMapping
	public EquipmentState update(@RequestBody EquipmentState equipmentState) {
		return this.service.save(equipmentState);

	}

	@GetMapping(path = "/{id}")
	public Optional<EquipmentState> findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping
	public ResponseEntity<Iterable<EquipmentState>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}
}


