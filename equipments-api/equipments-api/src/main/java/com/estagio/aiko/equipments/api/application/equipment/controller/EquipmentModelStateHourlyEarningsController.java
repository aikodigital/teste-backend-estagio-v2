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

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModelStateHourlyEarnings;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentModelStateHourlyEarningsService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.hourlyEarnings.EquipmentModelStateHourlyEarningsRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.hourlyEarnings.EquipmentModelStateHourlyEarningsResponse;

@RestController
@RequestMapping("/equipment-model-state-hourly-earnings")
public class EquipmentModelStateHourlyEarningsController {

	private final EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;
	private final ConverterServiceImpl converterService;

	public EquipmentModelStateHourlyEarningsController(
			EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService,
			ConverterServiceImpl converterService) {
		this.equipmentModelStateHourlyEarningsService = equipmentModelStateHourlyEarningsService;
		this.converterService = converterService;
	}

	@PostMapping()
	public ResponseEntity<EquipmentModelStateHourlyEarningsResponse> add(
			@Valid @RequestBody EquipmentModelStateHourlyEarningsRequest equipmentModelStateHourlyEarningsRequest) {
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = converterService
				.convert(equipmentModelStateHourlyEarningsRequest, EquipmentModelStateHourlyEarnings.class);
		EquipmentModelStateHourlyEarnings savedEquipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService
				.create(equipmentModelStateHourlyEarnings);
		EquipmentModelStateHourlyEarningsResponse equipmentModelStateHourlyEarningsResponse = converterService
				.convert(savedEquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentModelStateHourlyEarningsResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipmentModelStateHourlyEarningsResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentModelStateHourlyEarningsRequest equipmentModelStateHourlyEarningsRequest) {
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = converterService
				.convert(equipmentModelStateHourlyEarningsRequest, EquipmentModelStateHourlyEarnings.class);
		EquipmentModelStateHourlyEarnings savedEquipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService
				.update(id, equipmentModelStateHourlyEarnings);
		EquipmentModelStateHourlyEarningsResponse equipmentResponse = converterService
				.convert(savedEquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsResponse.class);

		return new ResponseEntity<>(equipmentResponse, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<EquipmentModelStateHourlyEarningsResponse>> getAll() {
		List<EquipmentModelStateHourlyEarnings> equipmentsModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService
				.findAll();
		List<EquipmentModelStateHourlyEarningsResponse> equipmentsModelStateHourlyEarningsResponse = converterService
				.convert(equipmentsModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsResponse.class);

		return new ResponseEntity<>(equipmentsModelStateHourlyEarningsResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentModelStateHourlyEarningsResponse> getById(@PathVariable UUID id) {
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService
				.findById(id);
		EquipmentModelStateHourlyEarningsResponse equipmentModelStateHourlyEarningsResponse = converterService
				.convert(equipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsResponse.class);

		return new ResponseEntity<>(equipmentModelStateHourlyEarningsResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
		equipmentModelStateHourlyEarningsService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
