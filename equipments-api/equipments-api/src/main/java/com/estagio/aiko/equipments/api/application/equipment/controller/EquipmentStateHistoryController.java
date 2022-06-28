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

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistory;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentStateHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.stateHistory.EquipmentStateHistoryRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.stateHistory.EquipmentStateHistoryResponse;

@RestController
@RequestMapping("/equipment-state-history")
public class EquipmentStateHistoryController {

	private final EquipmentStateHistoryService equipmentStateHistoryService;
	private final ConverterServiceImpl converterService;

	public EquipmentStateHistoryController(EquipmentStateHistoryService equipmentStateHistoryService,
			ConverterServiceImpl converterService) {
		this.equipmentStateHistoryService = equipmentStateHistoryService;
		this.converterService = converterService;
	}

	@PostMapping()
	public ResponseEntity<EquipmentStateHistoryResponse> add(
			@Valid @RequestBody EquipmentStateHistoryRequest equipmentStateHistoryRequest) {
		EquipmentStateHistory equipmentStateHistory = converterService.convert(equipmentStateHistoryRequest,
				EquipmentStateHistory.class);
		EquipmentStateHistory savedEquipmentStateHistory = equipmentStateHistoryService.create(equipmentStateHistory);
		EquipmentStateHistoryResponse equipmentStateHistoryResponse = converterService
				.convert(savedEquipmentStateHistory, EquipmentStateHistoryResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentStateHistoryResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipmentStateHistoryResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentStateHistoryRequest equipmentStateHistoryRequest) {
		EquipmentStateHistory equipmentStateHistory = converterService.convert(equipmentStateHistoryRequest,
				EquipmentStateHistory.class);
		EquipmentStateHistory savedEquipmentStateHistory = equipmentStateHistoryService.update(id,
				equipmentStateHistory);
		EquipmentStateHistoryResponse equipmentStateHistoryResponse = converterService
				.convert(savedEquipmentStateHistory, EquipmentStateHistoryResponse.class);

		return new ResponseEntity<>(equipmentStateHistoryResponse, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<EquipmentStateHistoryResponse>> getAll() {
		List<EquipmentStateHistory> equipmentsStateHistory = equipmentStateHistoryService.findAll();
		List<EquipmentStateHistoryResponse> equipmentsStateHistoryResponse = converterService
				.convert(equipmentsStateHistory, EquipmentStateHistoryResponse.class);

		return new ResponseEntity<>(equipmentsStateHistoryResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentStateHistoryResponse> getById(@PathVariable UUID id) {
		EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryService.findById(id);
		EquipmentStateHistoryResponse equipmentStateHistoryResponse = converterService.convert(equipmentStateHistory,
				EquipmentStateHistoryResponse.class);

		return new ResponseEntity<>(equipmentStateHistoryResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
		equipmentStateHistoryService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
