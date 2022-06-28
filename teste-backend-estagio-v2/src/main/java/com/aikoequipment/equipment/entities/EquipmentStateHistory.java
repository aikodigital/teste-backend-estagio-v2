package com.aikoequipment.equipment.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aikoequipment.equipment.entities.PK.EquipmentStateHistoryPK;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Column(updatable = false, unique = true, nullable = false)
	private EquipmentStateHistoryPK id = new EquipmentStateHistoryPK();
	private Instant date;

	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState state;

	public EquipmentStateHistory() {
	}

	public EquipmentStateHistory(Equipment equipment, EquipmentState state, Instant date) {
		id.setEquipment(equipment);
		this.date = date;
		this.state = state;
	}

	public Equipment getEquipment() {
		return id.getEquipment();
	}

	public void setEquipment(Equipment equipment) {
		id.setEquipment(equipment);
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public EquipmentState getEquipmentState() {
		return state;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.state = equipmentState;
	}

}
