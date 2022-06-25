package com.model;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 @Embeddable
public class StateHistoryId implements Serializable{
	@ManyToOne
	@JoinColumn(name="equipment_id")
	private Equipment equipment;
	
	@ManyToOne
	@JoinColumn(name="equipment_state_id")
	private EquipmentState equipmentstate;
	 
	 public StateHistoryId() {
		super();
	}
	public StateHistoryId(Equipment equipment, EquipmentState equipmentstate) {
			super();
			this.equipment = equipment;
			this.equipmentstate = equipmentstate;
			
		}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public EquipmentState getEquipmentstate() {
		return equipmentstate;
	}
	public void setEquipmentstate(EquipmentState equipmentstate) {
		this.equipmentstate = equipmentstate;
	}
	
	
	 
}


