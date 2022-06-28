package io.github.humbertoluiz.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStateDTO {
	
	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
	@NotBlank(message = "{campo.color.obrigatorio}")
	private String color;

}
