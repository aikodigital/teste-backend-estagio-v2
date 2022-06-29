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

import com.brunopereira.projetoaiko.entities.Equipment;
import com.brunopereira.projetoaiko.service.EquipmentService;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {

	@Autowired
	private EquipmentService service;

	@GetMapping
	public ResponseEntity<List<Equipment>> findAll() {
		List<Equipment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Equipment> findById(@PathVariable Long id) {
		Equipment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Equipment insert(@RequestBody Equipment obj) {
		return service.insert(obj);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Equipment> update(@PathVariable Long id, @RequestBody Equipment obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();
	}

}
