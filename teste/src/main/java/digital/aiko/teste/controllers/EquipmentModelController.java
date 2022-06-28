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

import digital.aiko.teste.model.entities.EquipmentModel;
import digital.aiko.teste.model.services.EquipmentModelServices;

@RestController
@RequestMapping(path = "/equipment-model")
public class EquipmentModelController {

	private EquipmentModelServices service;

	public EquipmentModelController(EquipmentModelServices service) {
		this.service = service;
	}

	@PostMapping
	public @ResponseBody EquipmentModel save(@RequestBody EquipmentModel equipmentModel) {
		this.service.save(equipmentModel);
		return equipmentModel;

	}

	@PutMapping
	public EquipmentModel update(@RequestBody EquipmentModel equipmentModel) {
		return this.service.save(equipmentModel);

	}

	@GetMapping(path = "/{id}")
	public Optional<EquipmentModel> findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping
	public ResponseEntity<Iterable<EquipmentModel>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}
}
