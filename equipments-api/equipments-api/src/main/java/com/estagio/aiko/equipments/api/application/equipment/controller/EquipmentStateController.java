package com.estagio.aiko.equipments.api.application.equipment.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

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

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentState;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentStateService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.state.EquipmentStateRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.state.EquipmentStateResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/equipment-state")
public class EquipmentStateController {

	private final EquipmentStateService equipmentStateService;
	private final ConverterServiceImpl converterService;

	public EquipmentStateController(EquipmentStateService equipmentStateService,
			ConverterServiceImpl converterService) {
		this.equipmentStateService = equipmentStateService;
		this.converterService = converterService;
	}

	@ApiOperation("Create a new equipment state")
	@PostMapping
	public ResponseEntity<EquipmentStateResponse> add(@Valid @RequestBody EquipmentStateRequest equipmentStateRequest) {
		EquipmentState equipmentState = converterService.convert(equipmentStateRequest, EquipmentState.class);
		EquipmentState savedEquipmentState = equipmentStateService.create(equipmentState);
		EquipmentStateResponse equipmentStateResponse = converterService.convert(savedEquipmentState,
				EquipmentStateResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentStateResponse);
	}

	@ApiOperation("Update an existing equipment state")
	@PutMapping("/{id}")
	public ResponseEntity<EquipmentStateResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentStateRequest equipmentStateRequest) {
		EquipmentState equipmentState = converterService.convert(equipmentStateRequest, EquipmentState.class);
		EquipmentState savedEquipmentState = equipmentStateService.update(id, equipmentState);
		EquipmentStateResponse equipmentStateResponse = converterService.convert(savedEquipmentState,
				EquipmentStateResponse.class);

		return new ResponseEntity<>(equipmentStateResponse, HttpStatus.OK);
	}

	@ApiOperation("Return all equipment states")
	@GetMapping
	public ResponseEntity<List<EquipmentStateResponse>> getAll() {
		List<EquipmentState> equipmentStates = equipmentStateService.findAll();
		List<EquipmentStateResponse> equipmentStatesResponse = converterService.convert(equipmentStates,
				EquipmentStateResponse.class);

		return new ResponseEntity<>(equipmentStatesResponse, HttpStatus.OK);
	}

	@ApiOperation("Find equipment state by ID")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentStateResponse> getById(@PathVariable UUID id) {
		EquipmentState equipmentState = equipmentStateService.findById(id);
		EquipmentStateResponse equipmentStateResponse = converterService.convert(equipmentState,
				EquipmentStateResponse.class);

		return new ResponseEntity<>(equipmentStateResponse, HttpStatus.OK);
	}

	@ApiOperation("Delete equipment state by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		equipmentStateService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
