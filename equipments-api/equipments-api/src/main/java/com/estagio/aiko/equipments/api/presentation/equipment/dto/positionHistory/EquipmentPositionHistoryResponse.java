package com.estagio.aiko.equipments.api.presentation.equipment.dto.positionHistory;

import java.time.LocalDateTime;
import java.util.UUID;

import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;

public class EquipmentPositionHistoryResponse {

	private UUID id;
	private Float latitude;
	private Float longitude;
	private LocalDateTime date;
	private Equipment equipment;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
