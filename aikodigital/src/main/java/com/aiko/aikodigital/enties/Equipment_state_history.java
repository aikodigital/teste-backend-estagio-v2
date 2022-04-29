package com.aiko.aikodigital.enties;
import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name= "Equipment_state_history")


public class Equipment_state_history {

	@Id
	private UUID equipment_id;
	
	@ManyToOne  
	@MapsId("equipment_state_id")
	private Equipment_state equipment_state_id;
	
	private Date date;

	public Equipment_state_history() {
		
	}
	public UUID getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(UUID equipment_id) {
		this.equipment_id = equipment_id;
	}
	public Equipment_state getEquipment_state_id() {
		return equipment_state_id;
	}
	public void setEquipment_state_id(Equipment_state equipment_state_id) {
		this.equipment_state_id = equipment_state_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
