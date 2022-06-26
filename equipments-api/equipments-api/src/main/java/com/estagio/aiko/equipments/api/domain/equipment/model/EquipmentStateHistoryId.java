package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class EquipmentStateHistoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState state;

	public EquipmentStateHistoryId() {
	}

	public EquipmentStateHistoryId(@NotNull Equipment equipment, @NotNull EquipmentState state) {
		this.equipment = equipment;
		this.state = state;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public EquipmentState getState() {
		return state;
	}

	public void setState(EquipmentState state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipment, state);
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
		return Objects.equals(equipment, other.equipment) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "EquipmentStateHistoryId [equipment=" + equipment + ", state=" + state + "]";
	}

}
