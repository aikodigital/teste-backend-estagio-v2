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

import com.aiko.domain.EquipmentStateHistory;
import com.aiko.services.EquipmentStateHistoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipmentStateHistory")
public class EquipmentStateHistoryResource {
	
	@Autowired
	private EquipmentStateHistoryService service;

	@ApiOperation(value = "Retorna um Historico do Estado do Equipamento")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentStateHistory> find(@PathVariable UUID id) {
		EquipmentStateHistory obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Retorna todos os Historicos do Estados do Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentStateHistory>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@ApiOperation(value = "Insere um Historico do Estado do Equipamento")
	@PostMapping
	public ResponseEntity<EquipmentStateHistory> save(@Valid @RequestBody EquipmentStateHistory equipmentState){
		EquipmentStateHistory obj = service.save(equipmentState);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um Historico do Estado do Equipamento")
	@PutMapping
	public ResponseEntity<EquipmentStateHistory> update(@Valid @RequestBody EquipmentStateHistory equipmentState){
		service.update(equipmentState);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta um Historico do Estado do Equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<EquipmentStateHistory> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna o Estado mais recente dos Equipamentos")
	@GetMapping("/allState")
	public ResponseEntity<List<EquipmentStateHistory>> findAllState(){
		return ResponseEntity.ok().body(service.findAllState());
	}
	
}
