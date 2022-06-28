package com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment;

import java.util.UUID;

import com.estagio.aiko.equipments.api.presentation.equipment.dto.model.EquipmentModelResponse;

public class EquipmentResponse {

	private UUID id;
	private String name;
	private EquipmentModelResponse model;

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

	public EquipmentModelResponse getModel() {
		return model;
	}

	public void setModel(EquipmentModelResponse model) {
		this.model = model;
	}

}
