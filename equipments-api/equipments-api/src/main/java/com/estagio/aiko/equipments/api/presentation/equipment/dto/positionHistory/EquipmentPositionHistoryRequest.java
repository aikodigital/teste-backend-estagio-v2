package com.estagio.aiko.equipments.api.presentation.equipment.dto.positionHistory;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class EquipmentPositionHistoryRequest {

	@NotNull
	private Float latitude;

	@NotNull
	private Float longitude;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private UUID equipmentId;

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

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

}
