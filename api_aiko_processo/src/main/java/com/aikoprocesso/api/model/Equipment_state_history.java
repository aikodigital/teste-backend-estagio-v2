package com.aikoprocesso.api.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_state_history")
public class Equipment_state_history {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@ManyToOne
	private Equipment equipment;
	
	@ManyToOne
	private Equipment_state equipment_state;
	
	private Date date;

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Equipment_state getEquipment_state() {
		return equipment_state;
	}

	public void setEquipment_state(Equipment_state equipment_state) {
		this.equipment_state = equipment_state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
