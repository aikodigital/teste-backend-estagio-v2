package com.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class PositionHistoryId  implements Serializable{
	@ManyToOne
	@JoinColumn(name="equipment_id")
	private Equipment equipment_id;
	
	private double lat;
	private double lon;
	public PositionHistoryId() {
		super();
	}
	public PositionHistoryId(Equipment equipment_id,  double lat, double lon) {
		super();
		this.equipment_id = equipment_id;
		
		this.lat = lat;
		this.lon = lon;
	}
	public Equipment getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment(Equipment equipment_id) {
		this.equipment_id = equipment_id;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	

}
