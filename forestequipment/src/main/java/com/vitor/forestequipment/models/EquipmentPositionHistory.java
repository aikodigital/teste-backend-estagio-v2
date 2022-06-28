package com.vitor.forestequipment.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory {

	@EmbeddedId
	private EquipmentPositionHistoryId equipmentPositionHistoryId;

	private LocalDateTime date;

	public EquipmentPositionHistory() {

	}

	public EquipmentPositionHistory(LocalDateTime date, EquipmentPositionHistoryId equipmentPositionHistoryId) {
		super();
		this.date = date;
		this.equipmentPositionHistoryId = equipmentPositionHistoryId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public EquipmentPositionHistoryId getEquipmentPositionHistoryId() {
		return equipmentPositionHistoryId;
	}

	public void setEquipmentPositionHistoryId(EquipmentPositionHistoryId equipmentPositionHistoryId) {
		this.equipmentPositionHistoryId = equipmentPositionHistoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipmentPositionHistoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistory other = (EquipmentPositionHistory) obj;
		return Objects.equals(equipmentPositionHistoryId, other.equipmentPositionHistoryId);
	}

}
