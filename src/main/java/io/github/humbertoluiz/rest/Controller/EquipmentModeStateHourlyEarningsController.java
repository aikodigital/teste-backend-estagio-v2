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
import io.github.humbertoluiz.domain.entity.EquipmentModelStateHourlyEarnings;
import io.github.humbertoluiz.dto.EquipmentModelStateHourlyEarningsDTO;
import io.github.humbertoluiz.service.EquipmentModelStateHourlyEarningsService;

@RestController
@RequestMapping("/api/v1/equipmentmodelstatehourlyearnings")
public class EquipmentModeStateHourlyEarningsController {

	@Autowired
	private EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentModelStateHourlyEarnings save(@RequestBody @Valid EquipmentModelStateHourlyEarningsDTO equipmentModeStateHourlyEarningsDTO) {
		EquipmentModelStateHourlyEarnings equipmentModeStateHourlyEarnings = equipmentModelStateHourlyEarningsService.save(equipmentModeStateHourlyEarningsDTO);
		return equipmentModeStateHourlyEarnings;
	}	
	
	@GetMapping("/{equipmentModelStateHourlyEarningstId}")
	public Optional<EquipmentModelStateHourlyEarnings> getById(@PathVariable UUID equipmentModelStateHourlyEarningsId) {
		return equipmentModelStateHourlyEarningsService.getById(equipmentModelStateHourlyEarningsId);
	}
	
	@DeleteMapping("/{equipmentModelStateHourlyEarningsId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentModelStateHourlyEarningsId ) {
		equipmentModelStateHourlyEarningsService.delete(equipmentModelStateHourlyEarningsId);
	}

	@PutMapping("/{equipmentModelStateHourlyEarningsId}")
	public void update(@PathVariable UUID equipmentModelStateHourlyEarningsId) {
		equipmentModelStateHourlyEarningsService.update(equipmentModelStateHourlyEarningsId);
	}

	@GetMapping
	public List<EquipmentModelStateHourlyEarnings> getByFilter(EquipmentModelStateHourlyEarnings filter) {		
		return equipmentModelStateHourlyEarningsService.getByFilter(filter);
	}
}
