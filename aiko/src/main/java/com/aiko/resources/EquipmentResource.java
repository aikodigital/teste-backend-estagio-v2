package com.aiko.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aiko.domain.Equipment;
import com.aiko.services.EquipmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipment")
public class EquipmentResource {
	
	@Autowired
	private EquipmentService equipmentService;

	@ApiOperation(value = "Retorna um Equipamento")
	@GetMapping("/{id}")
	public ResponseEntity<Equipment> find(@PathVariable UUID id) {
		Equipment obj = equipmentService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Retorna todos os Equipamentos")
	@GetMapping
	public ResponseEntity<List<Equipment>> findAll(){
		return ResponseEntity.ok().body(equipmentService.findAll());
	}
	
	@ApiOperation(value = "Insere um Equipamento")
	@PostMapping
	public ResponseEntity<Equipment> save(@Valid @RequestBody Equipment equipment){
		Equipment obj = equipmentService.save(equipment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um Equipamento")
	@PutMapping
	public ResponseEntity<Equipment> update(@Valid @RequestBody Equipment equipment){
		equipmentService.update(equipment);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta um Equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<Equipment> delete(@PathVariable UUID id){
		equipmentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
