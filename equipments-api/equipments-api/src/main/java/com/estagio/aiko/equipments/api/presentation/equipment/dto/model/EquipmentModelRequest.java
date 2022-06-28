package com.estagio.aiko.equipments.api.presentation.equipment.dto.model;

import javax.validation.constraints.NotBlank;

public class EquipmentModelRequest {

	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
