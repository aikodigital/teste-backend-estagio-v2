package com.aiko.aikodigital.enties;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name= "equipment_model_state_hourly_earnings")
public class Equipment_model_state_hourly_earnings {
	

	@ManyToMany
	@MapsId("equipment_model_id")
	private Equipment_model Equipment_model;

	@ManyToOne  
	@MapsId("equipment_state_id")
	private Equipment_state Equipment_state;

	private Double value;
	
	
	public Equipment_model_state_hourly_earnings() {
	}


	public Equipment_model getEquipment_model() {
		return Equipment_model;
	}


	public void setEquipment_model(Equipment_model equipment_model) {
		Equipment_model = equipment_model;
	}


	public Equipment_state getEquipment_state() {
		return Equipment_state;
	}


	public void setEquipment_state(Equipment_state equipment_state) {
		Equipment_state = equipment_state;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
}
