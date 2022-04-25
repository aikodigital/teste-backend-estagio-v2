package com.aikoprocesso.api.model;



import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class Equipment_model_state_hourly_earnings {
	
	@Id
	private UUID id;
	
	@ManyToOne
	private Equipment_model equipment_model;
		
	@ManyToOne
	private Equipment_state equipment_state;
	
	private double value;

	public Equipment_model getEquipment_model() {
		return equipment_model;
	}

	public void setEquipment_model(Equipment_model equipment_model) {
		this.equipment_model = equipment_model;
	}

	public Equipment_state getEquipment_state() {
		return equipment_state;
	}

	public void setEquipment_state(Equipment_state equipment_state) {
		this.equipment_state = equipment_state;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
