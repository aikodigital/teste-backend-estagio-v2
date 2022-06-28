package com.estagio.aiko.equipments.api.presentation.equipment.dto.hourlyEarnings;

import java.util.UUID;

import com.estagio.aiko.equipments.api.presentation.equipment.dto.model.EquipmentModelResponse;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.state.EquipmentStateResponse;

public class EquipmentModelStateHourlyEarningsResponse {

	private UUID id;
	private Float value;
	private EquipmentModelResponse model;
	private EquipmentStateResponse state;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public EquipmentModelResponse getModel() {
		return model;
	}

	public void setModel(EquipmentModelResponse model) {
		this.model = model;
	}

	public EquipmentStateResponse getState() {
		return state;
	}

	public void setState(EquipmentStateResponse state) {
		this.state = state;
	}

}
