package io.github.humbertoluiz.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor	
public class EquipmentModelDTO {
	
	private UUID equipmentModelId;
	
	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
}
