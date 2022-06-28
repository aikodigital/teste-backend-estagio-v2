package com.aikoequipment.equipment.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aikoequipment.equipment.entities.Equipment;

@Embeddable
public class EquipmentStateHistoryPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	public EquipmentStateHistoryPK() {
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistoryPK other = (EquipmentStateHistoryPK) obj;
		return Objects.equals(equipment, other.equipment);
	}

}
