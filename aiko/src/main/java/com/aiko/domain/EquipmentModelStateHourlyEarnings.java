package com.aiko.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    private UUID id;

    @MapsId("id")
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;

	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;
	
	@NotNull
	private BigDecimal value;
	
}
