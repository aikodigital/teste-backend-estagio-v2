package teste.backend.estagio.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import teste.backend.estagio.entities.Equipment;
import teste.backend.estagio.entities.EquipmentState;

@Embeddable
public class EquipmentStateHistoryPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;

	public EquipmentStateHistoryPk() {
		
	}
	
	public EquipmentStateHistoryPk(Equipment equipment,EquipmentState equipmentState) {
		this.equipment = equipment;
		this.equipmentState = equipmentState;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}
	
}
