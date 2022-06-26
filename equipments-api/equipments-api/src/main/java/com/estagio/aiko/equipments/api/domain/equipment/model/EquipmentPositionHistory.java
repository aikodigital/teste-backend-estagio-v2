package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipmentPositionHistoryId id;

	@NotNull
	@Column(name = "lat")
	private Float latitude;

	@NotNull
	@Column(name = "lon")
	private Float longitude;

	public EquipmentPositionHistory() {
	}

	public EquipmentPositionHistoryId getId() {
		return id;
	}

	public void setId(EquipmentPositionHistoryId id) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, latitude, longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistory other = (EquipmentPositionHistory) obj;
		return Objects.equals(id, other.id) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude);
	}

	@Override
	public String toString() {
		return "EquipmentPositionHistory [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
