package io.github.humbertoluiz.dto;

import javax.validation.constraints.NotBlank;

public class EquipmentStateDTO {
	
	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
	@NotBlank(message = "{campo.color.obrigatorio}")
	private String color;
	
	public EquipmentStateDTO() {}

	public EquipmentStateDTO(String name, String color) {
		this.name = name;
		this.color = color;
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
