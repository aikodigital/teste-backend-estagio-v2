package com.aiko.aikodigital.enties;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "equipment")
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private UUID id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@Column(name="equipment_model_id")
	private Equipment_model Equipment_model;
	

	public Equipment_model getModeloEquipamento() {
		return Equipment_model;
	}



	public void setModeloEquipamento(Equipment_model modeloEquipamento) {
		this.Equipment_model = modeloEquipamento;
	}



	public Equipment() {
	}

	

	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
