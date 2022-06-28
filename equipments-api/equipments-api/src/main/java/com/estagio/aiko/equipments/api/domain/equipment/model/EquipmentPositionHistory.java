package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id")
	private UUID id;

	@NotNull
	@Column(name = "lat")
	private Float latitude;

	@NotNull
	@Column(name = "lon")
	private Float longitude;

	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	public EquipmentPositionHistory() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, equipment, id, latitude, longitude);
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
		return Objects.equals(date, other.date) && Objects.equals(equipment, other.equipment)
				&& Objects.equals(id, other.id) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude);
	}

	@Override
	public String toString() {
		return "EquipmentPositionHistory [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", date="
				+ date + ", equipment=" + equipment + "]";
	}

}
