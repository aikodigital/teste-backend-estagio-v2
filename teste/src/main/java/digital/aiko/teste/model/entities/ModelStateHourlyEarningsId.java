package digital.aiko.teste.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ModelStateHourlyEarningsId implements Serializable {

	private static final long serialVersionUID = 6995558629966693867L;

	@OneToOne
	@JoinColumn(name = "equipment_state_id")

	private EquipmentState equipmentState;

	@OneToOne
	@JoinColumn(name = "equipment_model_id")

	private EquipmentModel equipmentModel;

	public ModelStateHourlyEarningsId() {

	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

}
