package com.model;

import javax.persistence.*;
//@Embeddable
@Entity
@Table(name="equipment_model_state_hourly_earnings",schema = "operation")

public class EquipmentModelStateHourlyEarnings {
	@EmbeddedId
	private ModelStateHourlyEarningsId msheid;
	
	public EquipmentModelStateHourlyEarnings(){
		
	}

	public EquipmentModelStateHourlyEarnings(ModelStateHourlyEarningsId msheid) {
		super();
		this.msheid = msheid;
	}

	public ModelStateHourlyEarningsId getMsheid() {
		return msheid;
	}

	public void setMsheid(ModelStateHourlyEarningsId msheid) {
		this.msheid = msheid;
	}
	

}
