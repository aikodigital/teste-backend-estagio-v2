package io.github.humbertoluiz.dto;

import javax.validation.constraints.NotBlank;
public class EquipmentModelDTO {

	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
	public EquipmentModelDTO() {}

	public EquipmentModelDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
