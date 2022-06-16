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

import com.aiko.domain.EquipmentState;
import com.aiko.services.EquipmentStateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipmentState")
public class EquipmentStateResource {
	
	@Autowired
	private EquipmentStateService equipmentStateService;

	@ApiOperation(value = "Retorna um Estado do Equipamento")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentState> find(@PathVariable UUID id) {
		EquipmentState obj = equipmentStateService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Retorna todos os Estados dos Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentState>> findAll(){
		return ResponseEntity.ok().body(equipmentStateService.findAll());
	}
	
	@ApiOperation(value = "Insere um Estado do Equipamento")
	@PostMapping
	public ResponseEntity<EquipmentState> save(@Valid @RequestBody EquipmentState equipmentState){
		EquipmentState obj = equipmentStateService.save(equipmentState);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um Estado do Equipamento")
	@PutMapping
	public ResponseEntity<EquipmentState> update(@Valid @RequestBody EquipmentState equipmentState){
		equipmentStateService.update(equipmentState);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta um Estado do Equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<EquipmentState> delete(@PathVariable UUID id){
		equipmentStateService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
