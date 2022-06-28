package com.aikoequipment.equipment.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.aikoequipment.equipment.entities.EquipmentStateHistory;

public class EquipmentStateHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	@NotBlank
	private UUID equipmentId;
	@NotBlank
	private UUID equipmentStateId;


	public EquipmentStateHistoryDTO(Instant date, UUID equipmentId, UUID equipmentStateId) {
		this.date = date;
		this.equipmentId = equipmentId;
		this.equipmentStateId = equipmentStateId;
	}

	public EquipmentStateHistoryDTO(EquipmentStateHistory entity) {
		this.date = entity.getDate();
		this.equipmentStateId = entity.getEquipmentState().getId();
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	public UUID getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(UUID equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

}
