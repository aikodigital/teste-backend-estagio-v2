package com.aikoequipment.equipment.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.aikoequipment.equipment.entities.EquipmentPositionHistory;

public class EquipmentPositionHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private UUID EquipmentPositionHistoryId;
	@NotBlank
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	@NotBlank
	@Column(columnDefinition = "REAL")
	private Double lat;
	@NotBlank
	@Column(columnDefinition = "REAL")
	private Double lon;

	public EquipmentPositionHistoryDTO(@NotBlank UUID equipmentPositionHistoryId, @NotBlank Instant date,
			@NotBlank Double lat, @NotBlank Double lon) {
		super();
		EquipmentPositionHistoryId = equipmentPositionHistoryId;
		this.date = date;
		this.lat = lat;
		this.lon = lon;
	}

	public EquipmentPositionHistoryDTO(EquipmentPositionHistory entity) {
		EquipmentPositionHistoryId = entity.getEquipment().getId();
		date = entity.getDate();
		lat = entity.getLat();
		lon = entity.getLon();
	}

	public UUID getEquipmentPositionHistoryId() {
		return EquipmentPositionHistoryId;
	}

	public void setEquipmentPositionHistoryId(UUID equipmentPositionHistoryId) {
		EquipmentPositionHistoryId = equipmentPositionHistoryId;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

}
