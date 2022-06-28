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

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistory;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentPositionHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.positionHistory.EquipmentPositionHistoryRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.positionHistory.EquipmentPositionHistoryResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/equipment-position-history")
public class EquipmentPositionHistoryController {

	private final EquipmentPositionHistoryService equipmentPositionHistoryService;
	private final ConverterServiceImpl converterService;

	public EquipmentPositionHistoryController(EquipmentPositionHistoryService equipmentPositionHistoryService,
			ConverterServiceImpl converterService) {
		this.equipmentPositionHistoryService = equipmentPositionHistoryService;
		this.converterService = converterService;
	}

	@ApiOperation("Create a new equipment position history")
	@PostMapping
	public ResponseEntity<EquipmentPositionHistoryResponse> add(
			@Valid @RequestBody EquipmentPositionHistoryRequest equipmentPositionHistoryRequest) {
		EquipmentPositionHistory equipmentPositionHistory = converterService.convert(equipmentPositionHistoryRequest,
				EquipmentPositionHistory.class);
		EquipmentPositionHistory savedEquipmentPositionHistory = equipmentPositionHistoryService
				.create(equipmentPositionHistory);
		EquipmentPositionHistoryResponse equipmentPositionHistoryResponse = converterService
				.convert(savedEquipmentPositionHistory, EquipmentPositionHistoryResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentPositionHistoryResponse);
	}

	@ApiOperation("Update an existing equipment position history")
	@PutMapping("/{id}")
	public ResponseEntity<EquipmentPositionHistoryResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentPositionHistoryRequest equipmentPositionHistoryRequest) {
		EquipmentPositionHistory equipmentPositionHistory = converterService.convert(equipmentPositionHistoryRequest,
				EquipmentPositionHistory.class);
		EquipmentPositionHistory savedEquipmentPositionHistory = equipmentPositionHistoryService.update(id,
				equipmentPositionHistory);
		EquipmentPositionHistoryResponse equipmentPositionHistoryResponse = converterService
				.convert(savedEquipmentPositionHistory, EquipmentPositionHistoryResponse.class);

		return new ResponseEntity<>(equipmentPositionHistoryResponse, HttpStatus.OK);
	}

	@ApiOperation("Return all equipment position history")
	@GetMapping
	public ResponseEntity<List<EquipmentPositionHistoryResponse>> getAll() {
		List<EquipmentPositionHistory> equipmentsPositionHistory = equipmentPositionHistoryService.findAll();
		List<EquipmentPositionHistoryResponse> equipmentsPositionHistoryResponse = converterService
				.convert(equipmentsPositionHistory, EquipmentPositionHistoryResponse.class);

		return new ResponseEntity<>(equipmentsPositionHistoryResponse, HttpStatus.OK);
	}

	@ApiOperation("Find position history by ID")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentPositionHistoryResponse> getById(@PathVariable UUID id) {
		EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryService.findById(id);
		EquipmentPositionHistoryResponse equipmentResponse = converterService.convert(equipmentPositionHistory,
				EquipmentPositionHistoryResponse.class);

		return new ResponseEntity<>(equipmentResponse, HttpStatus.OK);
	}

	@ApiOperation("Delete position history by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
		equipmentPositionHistoryService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
