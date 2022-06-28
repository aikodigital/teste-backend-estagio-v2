package com.estagio.aiko.equipments.api.presentation.equipment.dto.hourlyEarnings;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public class EquipmentModelStateHourlyEarningsRequest {

	@NotNull
	private Float value;

	@NotNull
	private UUID modelId;

	@NotNull
	private UUID stateId;

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public UUID getModelId() {
		return modelId;
	}

	public void setModelId(UUID modelId) {
		this.modelId = modelId;
	}

	public UUID getStateId() {
		return stateId;
	}

	public void setStateId(UUID stateId) {
		this.stateId = stateId;
	}

}
