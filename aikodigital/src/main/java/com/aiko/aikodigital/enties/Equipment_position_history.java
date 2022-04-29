package com.aiko.aikodigital.enties;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "equipment_position_history")
public class Equipment_position_history {

@Id
	private UUID equipment_id;
	private Date date;
	private Double lat;
	private Double lon;
	
	public Equipment_position_history() {
		
	}

	public UUID getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(UUID equipment_id) {
		this.equipment_id = equipment_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}



	
}
