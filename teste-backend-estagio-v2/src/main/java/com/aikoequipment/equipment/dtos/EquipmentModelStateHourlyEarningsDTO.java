package com.aikoequipment.equipment.dtos;

import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.aikoequipment.equipment.entities.EquipmentModelStateHourlyEarnings;

public class EquipmentModelStateHourlyEarningsDTO {

	@NotBlank
	private UUID equipmentModelId;
	@NotBlank
	private UUID equipmentStateId;
	@NotBlank
	@Column(columnDefinition = "REAL")
	private Double value;
	
	public EquipmentModelStateHourlyEarningsDTO(UUID equipmentModelId, UUID equipmentStateId,
			Double value) {
		super();
		this.equipmentModelId = equipmentModelId;
		this.equipmentStateId = equipmentStateId;
		this.value = value;
	}
	
	public EquipmentModelStateHourlyEarningsDTO(EquipmentModelStateHourlyEarnings entity) {
		super();
		equipmentModelId = entity.getEquipmentModel().getId();
		equipmentStateId = entity.getEquipmentState().getId();
		value = entity.getValue();
	}

	public UUID getEquipmentModelId() {
		return equipmentModelId;
	}

	public void setEquipmentModelId(UUID equipmentModelId) {
		this.equipmentModelId = equipmentModelId;
	}

	public UUID getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(UUID equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	
}
