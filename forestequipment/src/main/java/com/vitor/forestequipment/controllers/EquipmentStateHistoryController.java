package com.vitor.forestequipment.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.forestequipment.dtos.EquipmentStateHistoryDto;
import com.vitor.forestequipment.models.Equipment;
import com.vitor.forestequipment.models.EquipmentState;
import com.vitor.forestequipment.models.EquipmentStateHistory;
import com.vitor.forestequipment.models.EquipmentStateHistoryId;
import com.vitor.forestequipment.services.EquipmentStateHistoryService;

@RestController
@RequestMapping(value = "/api/equipment/statehistory")
public class EquipmentStateHistoryController {

	final EquipmentStateHistoryService equipmentStateHistoryService;

	public EquipmentStateHistoryController(EquipmentStateHistoryService equipmentStateHistoryService) {
		this.equipmentStateHistoryService = equipmentStateHistoryService;
	}

	@GetMapping("/{id}")
	public List<EquipmentStateHistoryDto> getAllEquipmentStates(@PathVariable(value = "id") UUID id) {

		List<EquipmentStateHistory> lista = equipmentStateHistoryService.getAllEquipmentStates(id);
		List<EquipmentStateHistoryDto> listaDTO = new ArrayList<>();

		for (EquipmentStateHistory equipmentStateHistory : lista) {
			EquipmentStateHistoryDto dto = new EquipmentStateHistoryDto();
			dto.setDate(equipmentStateHistory.getDate());
			listaDTO.add(dto);
		}

		return listaDTO.stream().map(p -> p).collect(Collectors.toList());
	}

	@PostMapping()
	public ResponseEntity<Object> saveEquipmentStateHistory(
			@RequestBody EquipmentStateHistoryDto equipmentStateHistoryDto) {
		var equipmentStateHistory = new EquipmentStateHistory();
		BeanUtils.copyProperties(equipmentStateHistoryDto, equipmentStateHistory);
		EquipmentStateHistoryId equipmentStateHistoryId = new EquipmentStateHistoryId();
		equipmentStateHistoryId.setEquipment(new Equipment(equipmentStateHistoryDto.getEquipmentId()));
		equipmentStateHistoryId.setEquipmentState(new EquipmentState(equipmentStateHistoryDto.getEquipmentStateId()));
		equipmentStateHistory.setDate(LocalDateTime.now());
		equipmentStateHistory.setEquipmentStateHistoryId(equipmentStateHistoryId);
		return ResponseEntity.status(HttpStatus.CREATED).body(equipmentStateHistoryService.save(equipmentStateHistory));
	}
}
