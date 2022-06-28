package com.estagio.aiko.equipments.api.presentation.equipment.dto.model;

import java.util.UUID;

public class EquipmentModelResponse {

	private UUID id;
	private String name;

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
	
}
