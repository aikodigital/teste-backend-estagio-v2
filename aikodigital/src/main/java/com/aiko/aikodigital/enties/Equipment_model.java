package com.aiko.aikodigital.enties;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "equipment_model")
public class Equipment_model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	private String name;
	
	public Equipment_model() {
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
