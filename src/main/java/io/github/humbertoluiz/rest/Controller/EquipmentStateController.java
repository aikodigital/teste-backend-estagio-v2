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
import io.github.humbertoluiz.domain.entity.EquipmentState;
import io.github.humbertoluiz.dto.EquipmentStateDTO;
import io.github.humbertoluiz.service.EquipmentStateService;

@RestController
@RequestMapping("/api/v1/equipmentstates")
public class EquipmentStateController {

	@Autowired
	private EquipmentStateService equipmentStateService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentState save(@RequestBody @Valid EquipmentStateDTO equipmentStateDTO) {
		EquipmentState equipmentState = equipmentStateService.save(equipmentStateDTO);
		return equipmentState;
	}	
	
	@GetMapping("/{equipmentStateId}")
	public Optional<EquipmentState> getById(@PathVariable UUID equipmentStateId) {
		return equipmentStateService.getById(equipmentStateId);
	}
	
	@DeleteMapping("/{equipmentStateId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentStateId ) {
		equipmentStateService.delete(equipmentStateId);
	}

	@PutMapping("/{equipmentStateId}")
	public void update(@PathVariable UUID equipmentStateId) {
		equipmentStateService.update(equipmentStateId);
	}

	@GetMapping
	public List<EquipmentState> getByFilter(EquipmentState filter) {		
		return equipmentStateService.getByFilter(filter);
	}
}
