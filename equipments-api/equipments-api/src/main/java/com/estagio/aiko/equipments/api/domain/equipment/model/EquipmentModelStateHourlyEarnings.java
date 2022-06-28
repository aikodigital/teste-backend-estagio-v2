package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
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
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings implements Serializable {

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
	@Column(name = "value")
	private Float value;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel model;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState state;

	public EquipmentModelStateHourlyEarnings() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public EquipmentModel getModel() {
		return model;
	}

	public void setModel(EquipmentModel model) {
		this.model = model;
	}

	public EquipmentState getState() {
		return state;
	}

	public void setState(EquipmentState state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, model, state, value);
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
		return Objects.equals(id, other.id) && Objects.equals(model, other.model) && Objects.equals(state, other.state)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "EquipmentModelStateHourlyEarnings [id=" + id + ", value=" + value + ", model=" + model + ", state="
				+ state + "]";
	}

}
