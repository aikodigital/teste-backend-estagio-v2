package com.aikoequipment.equipment.resources;

import java.net.URI;
import java.util.List;
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

import com.aikoequipment.equipment.dtos.EquipmentPositionHistoryDTO;
import com.aikoequipment.equipment.entities.EquipmentPositionHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentPositionHistoryPK;
import com.aikoequipment.equipment.services.EquipmentPositionHistoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/positions")
public class EquipmentPositionHistoryResource {

	@Autowired
	private EquipmentPositionHistoryService service;

	@ApiOperation(value = "Lista o histórico de posições dos equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentPositionHistoryDTO>> findAll() {
		List<EquipmentPositionHistory> list = service.findAll();
		List<EquipmentPositionHistoryDTO> listDto = list.stream().map(x -> new EquipmentPositionHistoryDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Lista o histórico de posições dos equipamentos por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentPositionHistoryDTO> findById(
			@PathVariable(value = "id") EquipmentPositionHistoryPK id) {
		EquipmentPositionHistoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value = "Cria o histórico de posições dos equipamentos")
	@PostMapping
	public ResponseEntity<EquipmentPositionHistoryDTO> insert(@RequestBody EquipmentPositionHistoryDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getEquipmentPositionHistoryId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@ApiOperation(value = "Atualiza o histórico de posições dos equipamentos")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentPositionHistoryDTO> update(@PathVariable(value = "id") EquipmentPositionHistoryPK id,
			@RequestBody EquipmentPositionHistoryDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value = "Deleta o histórico de posições dos equipamentos por id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") EquipmentPositionHistoryPK id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
