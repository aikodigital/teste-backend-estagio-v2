package com.aikoequipment.equipment.dtos;

import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.core.convert.converter.Converter;

import com.aikoequipment.equipment.entities.Equipment;
import com.aikoequipment.equipment.entities.EquipmentModel;

public class EquipmentDTO implements Converter<String, UUID> {

	@NotBlank
	private UUID id;
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String name;
	private EquipmentModel equipmentModel;

	public EquipmentDTO() {
	}

	public EquipmentDTO(EquipmentModel equipmentModel, UUID id, String name) {
		this.equipmentModel = equipmentModel;
		this.id = id;
		this.name = name;
	}

	public EquipmentDTO(Equipment entity) {
		equipmentModel = entity.getEquipmentModel();
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

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	@Override
	public UUID convert(String source) {
		// TODO Auto-generated method stub
		return null;
	}

}
