package io.github.humbertoluiz.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EquipmentDTO {
	
	@NotNull(message = "{campo.codigo-equipmentModel.name.obrigatorio}")
    private UUID equipmentModelId;
	
	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
	public EquipmentDTO() {}
	
	public EquipmentDTO(String name) {
		this.name = name;
	}

	public UUID getEquipmentModelId() {
		return equipmentModelId;
	}

	public void setEquipmentModelId(UUID equipmentModelId) {
		this.equipmentModelId = equipmentModelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
