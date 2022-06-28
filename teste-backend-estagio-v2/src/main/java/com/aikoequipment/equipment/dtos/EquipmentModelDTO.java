package com.aikoequipment.equipment.dtos;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.aikoequipment.equipment.entities.EquipmentModel;

public class EquipmentModelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private UUID id;
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String name;

	public EquipmentModelDTO() {
	}

	public EquipmentModelDTO(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public EquipmentModelDTO(EquipmentModel entity) {
		id = entity.getId();
		name = entity.getName();
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

}
