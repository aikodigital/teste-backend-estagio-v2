package com.model;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
//@Embeddable
@Entity
@Table(name="equipment_state_history",schema = "operation")

public class EquipmentStateHistory {
	@EmbeddedId
	private StateHistoryId id;
	private Date date;
	
	
	
	public EquipmentStateHistory() {
		
	}



	



	public EquipmentStateHistory(StateHistoryId id, Date data) {
		super();
		this.id = id;
		this.date = data;
	}







	public StateHistoryId getId() {
		return id;
	}



	public void setId(StateHistoryId id) {
		this.id = id;
	}



	public Date getData() {
		return date;
	}



	public void setData(Date data) {
		this.date = data;
	}
	
	
	

}
