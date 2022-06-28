package io.github.humbertoluiz.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
	
	@NotNull(message = "{campo.codigo-equipmentModel.name.obrigatorio}")
    private UUID equipmentModelId;
	
	@NotBlank(message = "{campo.name.obrigatorio}")
	private String name;
	
}
