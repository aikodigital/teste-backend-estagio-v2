package teste.backend.estagio.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import teste.backend.estagio.entities.EquipmentModel;
import teste.backend.estagio.entities.EquipmentState;

@Embeddable
public class EquipmentModelStateHourlyEarningsPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;
	
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;

	public EquipmentModelStateHourlyEarningsPk() {
		
	}
	
	public EquipmentModelStateHourlyEarningsPk(EquipmentModel equipmentModel,EquipmentState equipmentState) {
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

}
