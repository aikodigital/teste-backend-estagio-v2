package com.model;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="equipment", schema = "operation")
public class Equipment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="equipment_model_id")
	private EquipmentModel model_equipment;
	
	
	
	public Equipment(){
		
	}
	public Equipment(UUID id,String name, EquipmentModel model_equipment) {
		this.id=id;
		this.name=name;
		this.model_equipment=model_equipment;
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
	public EquipmentModel getModel_equipment() {
		return model_equipment;
	}
	public void setModel_equipment(EquipmentModel model_equipment) {
		this.model_equipment = model_equipment;
	}
	
}
