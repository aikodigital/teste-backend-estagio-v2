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

import com.aiko.domain.EquipmentModel;
import com.aiko.services.EquipmentModelService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipmentModel")
public class EquipmentModelResource {
	
	@Autowired
	private EquipmentModelService service;

	@ApiOperation(value = "Retorna um modelo de Equipamento")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentModel> find(@PathVariable UUID id) {
		EquipmentModel obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Retorna todos os modelos de Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentModel>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@ApiOperation(value = "Insere um modelo de Equipamento")
	@PostMapping
	public ResponseEntity<EquipmentModel> save(@Valid @RequestBody EquipmentModel equipmentModel){
		EquipmentModel obj = service.save(equipmentModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um modelo de Equipamento")
	@PutMapping
	public ResponseEntity<EquipmentModel> update(@Valid @RequestBody EquipmentModel equipmentModel){
		service.update(equipmentModel);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta um modelo de Equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<EquipmentModel> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
