package com.vitor.forestequipment.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory {

	@EmbeddedId
	private EquipmentStateHistoryId equipmentStateHistoryId;
	
	private LocalDateTime date;

	public EquipmentStateHistory(EquipmentStateHistoryId equipmentStateHistoryId, LocalDateTime date) {
		super();
		this.equipmentStateHistoryId = equipmentStateHistoryId;
		this.date = date;
	}
	
	public EquipmentStateHistory() {
		
	}

	public EquipmentStateHistoryId getEquipmentStateHistoryId() {
		return equipmentStateHistoryId;
	}

	public void setEquipmentStateHistoryId(EquipmentStateHistoryId equipmentStateHistoryId) {
		this.equipmentStateHistoryId = equipmentStateHistoryId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipmentStateHistoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistory other = (EquipmentStateHistory) obj;
		return Objects.equals(equipmentStateHistoryId, other.equipmentStateHistoryId);
	}
	
	
	
	
}
