package io.github.humbertoluiz.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModelStateHourlyEarningsDTO {
	
	@NotNull(message = "{campo.codigo-equipmentModel.obrigatorio}")
	private UUID equipmentModelId;
	
	@NotNull(message = "{campo.codigo-equipmentState.obrigatorio}")
	private UUID equipmentStateId;
	
	@NotNull(message = "{campo.value.obrigatorio}")
	private Float value;
	
}
