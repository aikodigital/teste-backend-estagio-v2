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

import com.aikoequipment.equipment.dtos.EquipmentStateHistoryDTO;
import com.aikoequipment.equipment.entities.EquipmentStateHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentStateHistoryPK;
import com.aikoequipment.equipment.services.EquipmentStateHistoryService;

@RestController
@RequestMapping(value = "/stateHistories")
public class EquipmentStateHistoryResource {
	
	@Autowired
	private EquipmentStateHistoryService service;

	@GetMapping
	public ResponseEntity<List<EquipmentStateHistoryDTO>> findAll() {
		List<EquipmentStateHistory> list = service.findAll();
		List<EquipmentStateHistoryDTO> listDto = list.stream().map(x -> new EquipmentStateHistoryDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentStateHistoryDTO> findById(@PathVariable EquipmentStateHistoryPK id) {
		EquipmentStateHistoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<EquipmentStateHistoryDTO> insert(@RequestBody EquipmentStateHistoryDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getEquipmentId(), dto.getEquipmentStateId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentStateHistoryDTO> update(@PathVariable EquipmentStateHistoryPK id, @RequestBody EquipmentStateHistoryDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable EquipmentStateHistoryPK id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
