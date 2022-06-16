package com.aiko.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
    private UUID id;

    @MapsId("id")
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@NotNull
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState equipmentState;
	
}
