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

import io.github.humbertoluiz.domain.entity.Equipment;
import io.github.humbertoluiz.dto.EquipmentDTO;
import io.github.humbertoluiz.service.EquipmentService;

@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Equipment save(@RequestBody @Valid EquipmentDTO equipmentDTO) {
		Equipment equipment = equipmentService.save(equipmentDTO);
		return equipment;
	}	
	
	@GetMapping("/{equipmentId}")
	public Optional<Equipment> getById(@PathVariable UUID equipmentId) {
		return equipmentService.getById(equipmentId);
	}
	
	@DeleteMapping("/{equipmentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentId ) {
		equipmentService.delete(equipmentId);
	}

	@PutMapping("/{equipmentId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@RequestBody Equipment equipment, @PathVariable UUID equipmentId) {
		equipmentService.update(equipmentId, equipment);
	}
	
	@GetMapping
	public List<Equipment> getByFilter(Equipment filter) {		
		return equipmentService.getByFilter(filter);
	}
}