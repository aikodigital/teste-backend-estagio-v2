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

import com.vitor.forestequipment.dtos.EquipmentPositionHistoryDto;
import com.vitor.forestequipment.models.Equipment;
import com.vitor.forestequipment.models.EquipmentPositionHistory;
import com.vitor.forestequipment.models.EquipmentPositionHistoryId;
import com.vitor.forestequipment.services.EquipmentPositionHistoryService;

@RestController
@RequestMapping(value = "/api/equipment/position")
public class EquipmentPositionHistoryController {

	final EquipmentPositionHistoryService equipmentPositionHistoryService;

	public EquipmentPositionHistoryController(EquipmentPositionHistoryService equipmentPositionHistoryService) {
		this.equipmentPositionHistoryService = equipmentPositionHistoryService;
	}

	@GetMapping("/{id}")
	public List<EquipmentPositionHistoryDto> getAllEquipmentPositions(@PathVariable(value = "id") UUID id) {

		List<EquipmentPositionHistory> lista = equipmentPositionHistoryService.getAllEquipmentPositions(id);
		List<EquipmentPositionHistoryDto> listaDTO = new ArrayList<>();

		for (EquipmentPositionHistory equipmentPositionHistory : lista) {
			EquipmentPositionHistoryDto dto = new EquipmentPositionHistoryDto();
			dto.setLat(equipmentPositionHistory.getEquipmentPositionHistoryId().getLat());
			dto.setLon(equipmentPositionHistory.getEquipmentPositionHistoryId().getLon());
			dto.setDate(equipmentPositionHistory.getDate());
			listaDTO.add(dto);
		}

		return listaDTO.stream().map(p -> p).collect(Collectors.toList());
	}

	@PostMapping()
	public ResponseEntity<Object> saveEquipmentPositionHistory(
			@RequestBody EquipmentPositionHistoryDto equipmentPositionHistoryDto) {
		var equipmentPositionHistory = new EquipmentPositionHistory();
		BeanUtils.copyProperties(equipmentPositionHistoryDto, equipmentPositionHistory);
		EquipmentPositionHistoryId equipmentPositionHistoryId = new EquipmentPositionHistoryId();
		equipmentPositionHistoryId.setEquipment(new Equipment(equipmentPositionHistoryDto.getEquipment()));
		equipmentPositionHistoryId.setLat(equipmentPositionHistoryDto.getLat());
		equipmentPositionHistoryId.setLon(equipmentPositionHistoryDto.getLon());
		equipmentPositionHistory.setDate(LocalDateTime.now());
		equipmentPositionHistory.setEquipmentPositionHistoryId(equipmentPositionHistoryId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(equipmentPositionHistoryService.save(equipmentPositionHistory));
	}

}
