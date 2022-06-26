package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipmentModelStateHourlyEarningsId id;

	@NotNull
	@Column(name = "value")
	private Float value;

	public EquipmentModelStateHourlyEarnings() {
	}

	public EquipmentModelStateHourlyEarningsId getId() {
		return id;
	}

	public void setId(EquipmentModelStateHourlyEarningsId id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentModelStateHourlyEarnings other = (EquipmentModelStateHourlyEarnings) obj;
		return Objects.equals(id, other.id) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "EquipmentModelStateHourlyEarnings [id=" + id + ", value=" + value + "]";
	}

}
