package com.estagio.aiko.equipments.api.presentation.equipment.dto.state;

import java.util.UUID;

public class EquipmentStateResponse {

	private UUID id;
	private String name;
	private String color;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
