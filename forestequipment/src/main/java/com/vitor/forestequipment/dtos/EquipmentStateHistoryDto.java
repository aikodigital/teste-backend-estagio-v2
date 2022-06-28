package com.vitor.forestequipment.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class EquipmentStateHistoryDto {

	private UUID equipmentId;
	
	private UUID equipmentStateId;
	
	private LocalDateTime date;
	

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
