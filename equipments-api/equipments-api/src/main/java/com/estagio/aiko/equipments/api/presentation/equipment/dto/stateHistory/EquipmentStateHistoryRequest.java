package com.estagio.aiko.equipments.api.presentation.equipment.dto.stateHistory;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class EquipmentStateHistoryRequest {

	@NotNull
	private LocalDateTime date;

	@NotNull
	private UUID equipmentId;

	@NotNull
	private UUID stateId;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	public UUID getStateId() {
		return stateId;
	}

	public void setStateId(UUID stateId) {
		this.stateId = stateId;
	}

}
