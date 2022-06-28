package com.aikoequipment.equipment.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aikoequipment.equipment.entities.EquipmentModel;
import com.aikoequipment.equipment.entities.EquipmentState;

@Embeddable
public class EquipmentModelStateHourlyEarningsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;

	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;

	public EquipmentModelStateHourlyEarningsPK() {
	}

	public EquipmentModelStateHourlyEarningsPK(EquipmentModel equipmentModel, EquipmentState equipmentState) {
		this.equipmentModel = equipmentModel;
		this.equipmentState = equipmentState;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipmentModel, equipmentState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentModelStateHourlyEarningsPK other = (EquipmentModelStateHourlyEarningsPK) obj;
		return Objects.equals(equipmentModel, other.equipmentModel)
				&& Objects.equals(equipmentState, other.equipmentState);
	}

}