package com.vitor.forestequipment.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

import com.vitor.forestequipment.dtos.EquipmentDto;
import com.vitor.forestequipment.models.Equipment;
import com.vitor.forestequipment.models.EquipmentModel;
import com.vitor.forestequipment.services.EquipmentService;

@RestController
@RequestMapping(value = "/api/equipment")
public class EquipmentController {

	final EquipmentService equipmentService;

	public EquipmentController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

	@GetMapping()
	public List<EquipmentDto> getAllEquipment() {

		List<Equipment> lista = equipmentService.findAll();
		List<EquipmentDto> listaDTO = new ArrayList<>();

		for (Equipment equipment : lista) {
			EquipmentDto dto = new EquipmentDto();
			dto.setId(equipment.getId());
			dto.setModel(equipment.getModel().getId());
			dto.setName(equipment.getName());
			listaDTO.add(dto);
		}

		return listaDTO.stream().map(p -> p).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public EquipmentDto equipment(@PathVariable(value = "id") UUID id) {
		Optional<Equipment> equipmentOptional = equipmentService.findById(id);
		EquipmentDto equipmentDto = new EquipmentDto();
		equipmentDto.setModel(equipmentOptional.get().getModel().getId());
		equipmentDto.setName(equipmentOptional.get().getName());
		equipmentDto.setId(equipmentOptional.get().getId());
		return equipmentDto;
	}

	@PostMapping()
	public ResponseEntity<Object> saveEquipment(@RequestBody EquipmentDto equipmentDto) {
		var equipment = new Equipment();
		BeanUtils.copyProperties(equipmentDto, equipment);
		equipment.setModel(new EquipmentModel(equipmentDto.getModel()));
		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentService.save(equipment));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEquipment(@PathVariable(value = "id") UUID id) {
		Optional<Equipment> equipmentOptional = equipmentService.findById(id);
		equipmentService.delete(equipmentOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Equipment deleted sucessfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<EquipmentDto> updateEquipment(@PathVariable(value = "id") UUID id,
			@RequestBody EquipmentDto equipmentDto) {
		Optional<Equipment> equipmentOptional = equipmentService.findById(id);

		var equipment = equipmentOptional.get();
		BeanUtils.copyProperties(equipmentDto, equipment);
		equipment.setId(id);
		equipmentService.save(equipment);
		return ResponseEntity.status(HttpStatus.OK).body(equipmentDto);
	}

}
