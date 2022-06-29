package teste.backend.estagio.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import teste.backend.estagio.entities.pk.EquipmentModelStateHourlyEarningsPk;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipmentModelStateHourlyEarningsPk id = new EquipmentModelStateHourlyEarningsPk();
	
	private Float value;

	public EquipmentModelStateHourlyEarnings() {

	}

	public EquipmentModelStateHourlyEarnings(EquipmentModel eModel, EquipmentState equipmentState, Float value) {
		super();
		id.setEquipmentModel(eModel);
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

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
