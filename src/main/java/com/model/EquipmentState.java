package com.model;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Embedded;



@Entity
@Table(name="equipment_state",schema = "operation")

public class EquipmentState {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Column(name="name")
	private String name;
	@Column(name="color")
	private String color;
	/*
	@Embedded
	private EquipmentModelStateHourlyEarnings emshe;
	@Embedded
	private EquipmentStateHistory esh;*/
	
	public EquipmentState(){
		
	}
	public EquipmentState(UUID id,String name, String color) {
		this.id=id;
		this.name=name;
		this.color=color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
