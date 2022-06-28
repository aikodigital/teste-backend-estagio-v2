package com.vitor.forestequipment.dtos;

import java.util.UUID;

public class EquipmentDto {

	private UUID id;

	private String name;

	private UUID model;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getModel() {
		return model;
	}

	public void setModel(UUID equipmentModel) {
		this.model = equipmentModel;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
