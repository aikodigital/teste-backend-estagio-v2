package com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class ModelStateHourlyEarningsId implements Serializable {
	@ManyToOne
	@JoinColumn(name="equipment_model_id")
	private EquipmentModel model_equipment;
	@ManyToOne
	@JoinColumn(name="equipment_state_id")
	private EquipmentState state_equipment;
	private int value;
	public ModelStateHourlyEarningsId() {
		super();
	}
	public ModelStateHourlyEarningsId(EquipmentModel model_equipment, EquipmentState state_equipment, int value) {
		super();
		this.model_equipment = model_equipment;
		this.state_equipment = state_equipment;
		this.value = value;
	}
	public EquipmentModel getModel_equipment() {
		return model_equipment;
	}
	public void setModel_equipment(EquipmentModel model_equipment) {
		this.model_equipment = model_equipment;
	}
	public EquipmentState getState_equipment() {
		return state_equipment;
	}
	public void setState_equipment(EquipmentState state_equipment) {
		this.state_equipment = state_equipment;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
