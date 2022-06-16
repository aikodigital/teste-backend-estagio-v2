package com.aiko.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory implements Serializable{

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
	@NotNull
	private BigDecimal lat;
	@NotNull
	private BigDecimal lon;

}
