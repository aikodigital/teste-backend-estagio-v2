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

import digital.aiko.teste.model.entities.Equipment;
import digital.aiko.teste.model.services.EquipmentServices;

@RestController
@RequestMapping(path = "/equipment")
public class EquipmentController {

	private EquipmentServices service;

	public EquipmentController(EquipmentServices service) {
		this.service = service;
	}

	@PostMapping
	public @ResponseBody Equipment save(@RequestBody Equipment equipment) {
		return this.service.save(equipment);

	}

	@PutMapping
	public Equipment update(@RequestBody Equipment equipment) {
		return this.service.save(equipment);

	}

	@GetMapping(path = "/{id}")
	public Optional<Equipment> findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping
	public ResponseEntity<Iterable<Equipment>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}

}
