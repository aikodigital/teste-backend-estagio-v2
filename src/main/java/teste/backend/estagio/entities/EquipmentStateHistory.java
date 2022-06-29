package teste.backend.estagio.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import teste.backend.estagio.entities.pk.EquipmentStateHistoryPk;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EquipmentStateHistoryPk id = new EquipmentStateHistoryPk();
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public EquipmentStateHistory() {
		
	}

	public EquipmentStateHistory(Equipment equipment, EquipmentState equipmentState, Date date) {
		super();
		id.setEquipment(equipment);
		id.setEquipmentState(equipmentState);
		this.date = date;

	}
	
	public Equipment getEquipment() {
		return id.getEquipment();
	}
	
	public void setEquipment(Equipment equipment) {
		id.setEquipment(equipment);
	}
	
	public EquipmentState getEquipmentState() {
		return id.getEquipmentState();
	}
	
	public void setEquipmentState(EquipmentState equipmentState) {
		id.setEquipmentState(equipmentState);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
