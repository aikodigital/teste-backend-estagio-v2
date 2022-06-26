package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class EquipmentModelStateHourlyEarningsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel model;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState state;

	public EquipmentModelStateHourlyEarningsId() {
	}

	public EquipmentModelStateHourlyEarningsId(@NotNull EquipmentModel model, @NotNull EquipmentState state) {
		this.model = model;
		this.state = state;
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
		return Objects.hash(model, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentModelStateHourlyEarningsId other = (EquipmentModelStateHourlyEarningsId) obj;
		return Objects.equals(model, other.model) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "EquipmentModelStateHourlyEarningsId [model=" + model + ", state=" + state + "]";
	}

}
