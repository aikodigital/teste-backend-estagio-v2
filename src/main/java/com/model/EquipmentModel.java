package com.model;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="equipment_model",schema = "operation")
public class EquipmentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Column(name="name")
	private String name;
	/*@Embedded
	private EquipmentModelStateHourlyEarnings emshe;
	@Embedded
	private EquipmentPositionHistory eph;
	*/
	public EquipmentModel(){
		
	}
	public EquipmentModel(UUID id,String name) {
		this.id=id;
		this.name=name;
		
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
