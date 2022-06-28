package io.github.humbertoluiz.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStateHistoryDTO {
	
	@NotNull(message = "{campo.codigo-equipment.obrigatorio}")	
	private UUID equipmentId;
	
	@NotNull(message = "{campo.codigo-equipmentState.obrigatorio}")
	private UUID equipmentStateId;

	private LocalDateTime date;
	
}
