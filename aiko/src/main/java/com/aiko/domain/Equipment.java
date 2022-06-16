package com.aiko.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "equipment", schema = "operation")
public class Equipment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipment")
	private List<EquipmentStateHistory> equipmentStateHistory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipment")
	private List<EquipmentPositionHistory> equipmentPositionHistory;
	
}
