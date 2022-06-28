package com.vitor.forestequipment.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EquipmentStateHistoryId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;

	public EquipmentStateHistoryId() {

	}

	public EquipmentStateHistoryId(Equipment equipment, EquipmentState equipmentState) {
		super();
		this.equipment = equipment;
		this.equipmentState = equipmentState;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipment, equipmentState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistoryId other = (EquipmentStateHistoryId) obj;
		return Objects.equals(equipment, other.equipment) && Objects.equals(equipmentState, other.equipmentState);
	}

}
