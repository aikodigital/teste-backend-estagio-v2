package com.aikoequipment.equipment.dtos;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.aikoequipment.equipment.entities.EquipmentState;

public class EquipmentStateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private UUID id;
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String name;
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String color;
	
	public EquipmentStateDTO() {
	}

	public EquipmentStateDTO(UUID id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}
	
	public EquipmentStateDTO(EquipmentState entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.color = entity.getColor();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
