package com.aikoequipment.equipment.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

import com.aikoequipment.equipment.dtos.EquipmentModelDTO;
import com.aikoequipment.equipment.entities.EquipmentModel;
import com.aikoequipment.equipment.services.EquipmentModelService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/models")
public class EquipmentModelResource {
	
	@Autowired
	private EquipmentModelService service;
	
	@ApiOperation(value="Lista todas os modelos de equipamentos")
	@GetMapping
 	public ResponseEntity<List<EquipmentModelDTO>> findAll() {
		List<EquipmentModel> list = service.findAll();
		List<EquipmentModelDTO> listDto = list.stream().map(x -> new EquipmentModelDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value="Lista todas os modelos de equipamentos por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentModelDTO> findById(@PathVariable UUID id) {
		EquipmentModelDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@ApiOperation(value="Cria um novo modelo de equipamento")
	@PostMapping
	public ResponseEntity<EquipmentModelDTO> insert(@RequestBody EquipmentModelDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@ApiOperation(value="Atualiza os modelos de equipamentos por id")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentModelDTO> update(@PathVariable UUID id, @RequestBody EquipmentModelDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Deleta os modelos de equipamentos")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
