package com.estagio.aiko.equipments.api.presentation.equipment.dto.stateHistory;

import java.time.LocalDateTime;
import java.util.UUID;

import com.estagio.aiko.equipments.api.presentation.equipment.dto.equipment.EquipmentResponse;
import com.estagio.aiko.equipments.api.presentation.equipment.dto.state.EquipmentStateResponse;

public class EquipmentStateHistoryResponse {

	private UUID id;
	private LocalDateTime date;
	private EquipmentResponse equipment;
	private EquipmentStateResponse state;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public EquipmentResponse getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentResponse equipment) {
		this.equipment = equipment;
	}

	public EquipmentStateResponse getState() {
		return state;
	}

	public void setState(EquipmentStateResponse state) {
		this.state = state;
	}

}
