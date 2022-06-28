package digital.aiko.teste.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ModelStateHistoryId implements Serializable {

	private static final long serialVersionUID = 3677271633488800589L;

	@OneToOne
	@JoinColumn(name = "equipment_state_id")

	private EquipmentState equipmentState;

	@OneToOne
	@JoinColumn(name = "equipment_id")

	private Equipment equipment;

	public ModelStateHistoryId() {

	}

	public ModelStateHistoryId(Equipment equipment) {

		this.equipment = equipment;
	}

	public ModelStateHistoryId(EquipmentState equipmentState) {

		this.equipmentState = equipmentState;
	}

	public ModelStateHistoryId(EquipmentState equipmentState, Equipment equipment) {
		this.equipmentState = equipmentState;
		this.equipment = equipment;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
