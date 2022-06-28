package com.estagio.aiko.equipments.api.presentation.equipment.dto.model;

import java.util.List;
import java.util.UUID;

import com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment.EquipmentResponse;

public class EquipmentModelResponse {

	private UUID id;
	private String name;
	private List<EquipmentResponse> equipments;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EquipmentResponse> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<EquipmentResponse> equipments) {
		this.equipments = equipments;
	}

}
