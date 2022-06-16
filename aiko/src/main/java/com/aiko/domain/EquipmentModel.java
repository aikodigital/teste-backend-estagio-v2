package com.aiko.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "equipment_model", schema = "operation")
public class EquipmentModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipmentModel")
	private List<Equipment> equipment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipmentModel")
	private List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
	
}
