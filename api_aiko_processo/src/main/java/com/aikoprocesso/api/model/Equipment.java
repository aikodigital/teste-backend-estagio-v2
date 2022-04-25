package com.aikoprocesso.api.model;

import java.util.UUID;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "equipment")
public class Equipment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@ManyToOne
	private Equipment_model equipment_model;
	
	private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Equipment_model getEquipment_model() {
		return equipment_model;
	}

	public void setEquipment_model(Equipment_model equipment_model) {
		this.equipment_model = equipment_model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
