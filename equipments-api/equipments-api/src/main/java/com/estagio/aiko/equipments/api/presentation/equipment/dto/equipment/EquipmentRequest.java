package com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EquipmentRequest {

	@NotBlank
	private String name;

	@NotNull
	private UUID modelId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getModelId() {
		return modelId;
	}

	public void setModelId(UUID modelId) {
		this.modelId = modelId;
	}

}
