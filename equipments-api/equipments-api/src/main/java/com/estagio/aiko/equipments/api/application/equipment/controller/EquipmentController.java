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

import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment.EquipmentRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment.EquipmentResponse;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

	private final EquipmentService equipmentService;
	private final ConverterServiceImpl converterService;

	public EquipmentController(EquipmentService equipmentService, ConverterServiceImpl converterService) {
		this.equipmentService = equipmentService;
		this.converterService = converterService;
	}

	@PostMapping()
	public ResponseEntity<EquipmentResponse> add(@Valid @RequestBody EquipmentRequest equipmentRequest) {
		Equipment equipment = converterService.convert(equipmentRequest, Equipment.class);
		Equipment savedEquipment = equipmentService.create(equipment);
		EquipmentResponse equipmentResponse = converterService.convert(savedEquipment, EquipmentResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipmentResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentRequest equipmentRequest) {
		Equipment equipment = converterService.convert(equipmentRequest, Equipment.class);
		Equipment savedEquipment = equipmentService.update(id, equipment);
		EquipmentResponse equipmentResponse = converterService.convert(savedEquipment, EquipmentResponse.class);

		return new ResponseEntity<>(equipmentResponse, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<EquipmentResponse>> getAll() {
		List<Equipment> equipments = equipmentService.findAll();
		List<EquipmentResponse> equipmentsResponse = converterService.convert(equipments, EquipmentResponse.class);

		return new ResponseEntity<>(equipmentsResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentResponse> getById(@PathVariable UUID id) {
		Equipment equipment = equipmentService.findById(id);
		EquipmentResponse equipmentResponse = converterService.convert(equipment, EquipmentResponse.class);

		return new ResponseEntity<>(equipmentResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
		equipmentService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
