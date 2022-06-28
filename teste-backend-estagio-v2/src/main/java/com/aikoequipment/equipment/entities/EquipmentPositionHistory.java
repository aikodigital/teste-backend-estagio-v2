package com.aikoequipment.equipment.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aikoequipment.equipment.entities.PK.EquipmentPositionHistoryPK;

@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Column(updatable = false, unique = true, nullable = false)
	private EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK();
	private Instant date;
	private Double lat;
	private Double lon;

	public EquipmentPositionHistory() {
	}

	public EquipmentPositionHistory(Equipment equipment, Instant date, Double lat, Double lon) {
		id.setEquipment(equipment);
		this.date = date;
		this.lat = lat;
		this.lon = lon;
	}

	public Equipment getEquipment() {
		return id.getEquipment();
	}

	public void setEquipment(Equipment equipment) {
		id.setEquipment(equipment);
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
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
