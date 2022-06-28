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

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentModelService;
import com.estagio.aiko.equipments.api.infrastructure.converter.ConverterServiceImpl;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.model.EquipmentModelRequest;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.model.EquipmentModelResponse;

@RestController
@RequestMapping("/equipment-model")
public class EquipmentModelController {

	private final EquipmentModelService equipmentModelService;
	private final ConverterServiceImpl converterService;

	public EquipmentModelController(EquipmentModelService equipmentModelService,
			ConverterServiceImpl converterService) {
		this.equipmentModelService = equipmentModelService;
		this.converterService = converterService;
	}

	@PostMapping()
	public ResponseEntity<EquipmentModelResponse> add(@Valid @RequestBody EquipmentModelRequest equipmentModelRequest) {
		EquipmentModel equipmentModel = converterService.convert(equipmentModelRequest, EquipmentModel.class);
		EquipmentModel savedEquipmentModel = equipmentModelService.create(equipmentModel);
		EquipmentModelResponse equipmentModelResponse = converterService.convert(savedEquipmentModel,
				EquipmentModelResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentModelResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipmentModelResponse> update(@PathVariable UUID id,
			@Valid @RequestBody EquipmentModelRequest equipmentModelRequest) {
		EquipmentModel equipmentModel = converterService.convert(equipmentModelRequest, EquipmentModel.class);
		EquipmentModel savedEquipmentModel = equipmentModelService.update(id, equipmentModel);
		EquipmentModelResponse equipmentModelResponse = converterService.convert(savedEquipmentModel,
				EquipmentModelResponse.class);

		return new ResponseEntity<>(equipmentModelResponse, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<EquipmentModelResponse>> getAll() {
		List<EquipmentModel> equipmentModels = equipmentModelService.findAll();
		List<EquipmentModelResponse> equipmentModelsResponse = converterService.convert(equipmentModels,
				EquipmentModelResponse.class);

		return new ResponseEntity<>(equipmentModelsResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentModelResponse> getById(@PathVariable UUID id) {
		EquipmentModel equipmentModel = equipmentModelService.findById(id);
		EquipmentModelResponse equipmentModelResponse = converterService.convert(equipmentModel,
				EquipmentModelResponse.class);

		return new ResponseEntity<>(equipmentModelResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		equipmentModelService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
