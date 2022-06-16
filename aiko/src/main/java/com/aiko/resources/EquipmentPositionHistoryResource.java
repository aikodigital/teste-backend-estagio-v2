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

import com.aiko.domain.EquipmentPositionHistory;
import com.aiko.services.EquipmentPositionHistoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipmentPositionHistoryPositionHistory")
public class EquipmentPositionHistoryResource {
	
	@Autowired
	private EquipmentPositionHistoryService service;
	
	@ApiOperation(value = "Retorna a posição mais recente dos Equipamentos")
	@GetMapping("/allPosition")
	public ResponseEntity<List<EquipmentPositionHistory>> findAllPosition(){
		return ResponseEntity.ok().body(service.findPosition());
	}
	
	@ApiOperation(value = "Retorna todos os historicos das posições dos Equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentPositionHistory>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@ApiOperation(value = "Insere um historico da posição de um Equipamento")
	@PostMapping
	public ResponseEntity<EquipmentPositionHistory> save(@Valid @RequestBody EquipmentPositionHistory EquipmentPositionHistory){
		EquipmentPositionHistory obj = service.save(EquipmentPositionHistory);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um historico da posição de um Equipamento")
	@PutMapping
	public ResponseEntity<EquipmentPositionHistory> update(@Valid @RequestBody EquipmentPositionHistory EquipmentPositionHistory){
		service.update(EquipmentPositionHistory);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta um historico da posição de um Equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<EquipmentPositionHistory> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
