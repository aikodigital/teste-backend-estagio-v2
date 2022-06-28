package com.vitor.forestequipment.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.forestequipment.dtos.EquipmentStateDto;
import com.vitor.forestequipment.models.EquipmentState;
import com.vitor.forestequipment.services.EquipmentStateService;

@RestController
@RequestMapping(value = "api/equipment/state")
public class EquipmentStateController {

	final EquipmentStateService equipmentStateService;

	public EquipmentStateController(EquipmentStateService equipmentStateService) {
		this.equipmentStateService = equipmentStateService;
	}

	@GetMapping()
	public ResponseEntity<Object> getAllEquipmentState() {
		return ResponseEntity.status(HttpStatus.OK).body(equipmentStateService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> EquipmentStateId(@PathVariable(value = "id") UUID id) {
		Optional<EquipmentState> equipmentStateOptional = equipmentStateService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(equipmentStateOptional.get());
	}

	@PostMapping()
	public ResponseEntity<Object> saveEquipmentState(@RequestBody EquipmentStateDto equipmentStateDto) {
		var equipmentState = new EquipmentState();
		BeanUtils.copyProperties(equipmentStateDto, equipmentState);
		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentStateService.save(equipmentState));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEquipmentState(@PathVariable(value = "id") UUID id) {
		Optional<EquipmentState> equipmentStateOptional = equipmentStateService.findById(id);
		equipmentStateService.delete(equipmentStateOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Equipment state deleted sucessfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEquipmentState(@PathVariable(value = "id") UUID id,
			@RequestBody EquipmentStateDto equipmentStateDto) {
		Optional<EquipmentState> equipmentStateOptional = equipmentStateService.findById(id);

		var equipmentState = equipmentStateOptional.get();
		BeanUtils.copyProperties(equipmentStateDto, equipmentState);
		equipmentState.setId(equipmentStateOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(equipmentStateService.save(equipmentState));
	}

}
