package com.estagio.aiko.equipments.api.presentation.equipment.dto.state;

import javax.validation.constraints.NotBlank;

public class EquipmentStateRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
