package com.model;


import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
//@Embeddable
@Entity

@Table(name="equipment_position_history", schema = "operation")
public class EquipmentPositionHistory {
	@EmbeddedId
	private PositionHistoryId positionhistoryid;
	private Date date;
	
	

	public EquipmentPositionHistory(PositionHistoryId positionhistoryid, Date date) {
		
		this.positionhistoryid = positionhistoryid;
		this.date = date;
	}
	public EquipmentPositionHistory() {
		
	}
	public PositionHistoryId getPositionhistoryid() {
		return positionhistoryid;
	}



	public void setPositionhistoryid(PositionHistoryId positionhistoryid) {
		this.positionhistoryid = positionhistoryid;
	}
	public Date getDate() {
		return date;
	}
	public void setData(Date date) {
		this.date = date;
	}
	
}
