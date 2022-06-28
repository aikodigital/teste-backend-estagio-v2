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

import com.vitor.forestequipment.dtos.EquipmentModelDto;
import com.vitor.forestequipment.models.EquipmentModel;
import com.vitor.forestequipment.services.EquipmentModelService;

@RestController
@RequestMapping(value = "/api/equipment/model")
public class EquipmentModelController {

	final EquipmentModelService equipmentModelService;

	public EquipmentModelController (EquipmentModelService equipmentModelService) {
			this.equipmentModelService = equipmentModelService;
	}

	@GetMapping()
	public ResponseEntity<Object> getAllEquipmentModel() {
		return ResponseEntity.status(HttpStatus.OK).body(equipmentModelService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> EquipmentModel(@PathVariable(value = "id") UUID id) {
		Optional<EquipmentModel> equipmentModelOptional = equipmentModelService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(equipmentModelOptional.get());
	}

	@PostMapping()
	public ResponseEntity<Object> saveEquipmentModel(@RequestBody EquipmentModelDto equipmentModelDto) {
		var equipmentModel = new EquipmentModel();
		BeanUtils.copyProperties(equipmentModelDto, equipmentModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentModelService.save(equipmentModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEquipmentModel(@PathVariable(value = "id") UUID id) {
		Optional<EquipmentModel> equipmentModelOptional = equipmentModelService.findById(id);
		equipmentModelService.delete(equipmentModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Equipment model deleted sucessfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEquipmentModel(@PathVariable(value = "id")UUID id,
												  @RequestBody EquipmentModelDto equipmentModelDto) {
		  Optional<EquipmentModel> equipmentModelOptional = equipmentModelService.findById(id);
	        
	        var equipmentModel = equipmentModelOptional.get();
	        BeanUtils.copyProperties(equipmentModelDto, equipmentModel);
	        equipmentModel.setId(equipmentModelOptional.get().getId());
	        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelService.save(equipmentModel));
	}

}
