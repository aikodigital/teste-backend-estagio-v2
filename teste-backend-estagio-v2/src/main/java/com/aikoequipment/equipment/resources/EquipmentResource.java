package com.aikoequipment.equipment.resources;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aikoequipment.equipment.dtos.EquipmentDTO;
import com.aikoequipment.equipment.entities.Equipment;
import com.aikoequipment.equipment.services.EquipmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {

	@Autowired
	private EquipmentService service;

	@ApiOperation(value="Lista todos os equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentDTO>> findAll() {
		List<Equipment> list = service.findAll();
		List<EquipmentDTO> listDto = list.stream().map(x -> new EquipmentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value="Lista os equipamentos por id")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentDTO> findById(@PathVariable UUID id) {
		EquipmentDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Cria os equipamentos")
	@PostMapping
	public ResponseEntity<EquipmentDTO> insert(@Valid @RequestParam EquipmentDTO dto) {
		dto = service.insert(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@ApiOperation(value="Atualiza os equipamentos")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentDTO> update(@Valid @RequestParam UUID id, @Valid @RequestBody EquipmentDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Deleta os equipamentos")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
