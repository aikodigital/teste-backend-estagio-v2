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
import io.github.humbertoluiz.domain.entity.EquipmentStateHistory;
import io.github.humbertoluiz.dto.EquipmentStateHistoryDTO;
import io.github.humbertoluiz.service.EquipmentStateHistoryService;

@RestController
@RequestMapping("/api/v1/equipmentstatehistory")
public class EquipmentStateHistoryController {

	@Autowired
	private EquipmentStateHistoryService equipmentStateHistoryService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentStateHistory save(@RequestBody @Valid EquipmentStateHistoryDTO equipmentStateHistoryDTO) {
		EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryService.save(equipmentStateHistoryDTO);
		return equipmentStateHistory;
	}	
	
	@GetMapping("/{equipmentStateHistoryId}")
	public Optional<EquipmentStateHistory> getById(@PathVariable UUID equipmentStateHistoryId) {
		return equipmentStateHistoryService.getById(equipmentStateHistoryId);
	}
	
	@DeleteMapping("/{equipmentStateHistoryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentStateHistoryId ) {
		equipmentStateHistoryService.delete(equipmentStateHistoryId);
	}

	@PutMapping("/{equipmentStateHistoryId}")
	public void update(@PathVariable UUID equipmentStateHistoryId) {
		equipmentStateHistoryService.update(equipmentStateHistoryId);
	}

	@GetMapping
	public List<EquipmentStateHistory> getByFilter(EquipmentStateHistory filter) {		
		return equipmentStateHistoryService.getByFilter(filter);
	}
}
