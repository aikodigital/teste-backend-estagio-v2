package io.github.humbertoluiz.rest.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.github.humbertoluiz.domain.entity.EquipmentPositionHistory;
import io.github.humbertoluiz.dto.EquipmentPositionHistoryDTO;
import io.github.humbertoluiz.service.EquipmentPositionHystoryService;

@RestController
@RequestMapping("/api/v1/equipmentpositionhistory")
public class EquipmentPositionHistoryController {

	@Autowired
	private EquipmentPositionHystoryService equipmentPositionHistoryService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentPositionHistory save(@RequestBody @Valid EquipmentPositionHistoryDTO equipmentPositionHistoryDTO) {
		EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryService.save(equipmentPositionHistoryDTO);
		return equipmentPositionHistory;
	}	
	
	@GetMapping("/{equipmentPositionHistoryId}")
	public Optional<EquipmentPositionHistory> getById(@PathVariable UUID equipmentPositionHistoryId) {
		return equipmentPositionHistoryService.getById(equipmentPositionHistoryId);
	}
	
	@DeleteMapping("/{equipmentPositionHistoryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentPositionHistoryId ) {
		equipmentPositionHistoryService.delete(equipmentPositionHistoryId);
	}

	@PutMapping("/{equipmentPositionHistoryId}")
	public void update(@PathVariable UUID equipmentPositionHistoryId) {
		equipmentPositionHistoryService.update(equipmentPositionHistoryId);
	}

	@GetMapping
	public List<EquipmentPositionHistory> getByFilter(EquipmentPositionHistory filter) {		
		return equipmentPositionHistoryService.getByFilter(filter);
	}
}
