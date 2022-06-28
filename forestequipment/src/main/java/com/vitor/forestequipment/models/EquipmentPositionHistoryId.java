package com.vitor.forestequipment.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EquipmentPositionHistoryId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	@Column(name = "lat")
	private double lat;

	@Column(name = "lon")
	private double lon;

	public EquipmentPositionHistoryId() {

	}

	public EquipmentPositionHistoryId(double lat, double lon, Equipment equipment) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.equipment = equipment;
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

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipment, lat, lon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistoryId other = (EquipmentPositionHistoryId) obj;
		return Objects.equals(equipment, other.equipment)
				&& Double.doubleToLongBits(lat) == Double.doubleToLongBits(other.lat)
				&& Double.doubleToLongBits(lon) == Double.doubleToLongBits(other.lon);
	}

}
