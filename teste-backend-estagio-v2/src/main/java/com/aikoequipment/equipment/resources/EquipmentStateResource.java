package com.aikoequipment.equipment.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

import com.aikoequipment.equipment.dtos.EquipmentStateDTO;
import com.aikoequipment.equipment.entities.EquipmentState;
import com.aikoequipment.equipment.services.EquipmentStateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/states")
public class EquipmentStateResource {

	@Autowired
	private EquipmentStateService service;

	@ApiOperation(value="Lista o estado dos equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentState>> findAll() {
		List<EquipmentState> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value="Lista o estado dos equipamentos por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentStateDTO> findById(@PathVariable UUID id) {
		EquipmentStateDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Cria o estado dos equipamentos")
	@PostMapping
	public ResponseEntity<EquipmentStateDTO> insert(@RequestBody EquipmentStateDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@ApiOperation(value="Atualiza o estado dos equipamentos")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentStateDTO> update(@PathVariable UUID id, @RequestBody EquipmentStateDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Deleta o estado dos equipamentos por id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
