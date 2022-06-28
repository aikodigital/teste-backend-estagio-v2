package com.aikoequipment.equipment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aikoequipment.equipment.entities.PK.EquipmentModelStateHourlyEarningsPK;

@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Column(updatable = false, unique = true, nullable = false)
	private EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK();
	private Double value;

	public EquipmentModelStateHourlyEarnings() {
	}

	public EquipmentModelStateHourlyEarnings(EquipmentModel equipmentModel, EquipmentState equipmentState,
			Double value) {
		id.setEquipmentModel(equipmentModel);
		id.setEquipmentState(equipmentState);
		this.value = value;
	}

	public EquipmentModel getEquipmentModel() {
		return id.getEquipmentModel();
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		id.setEquipmentModel(equipmentModel);
	}

	public EquipmentState getEquipmentState() {
		return id.getEquipmentState();
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		id.setEquipmentState(equipmentState);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
