package io.github.humbertoluiz.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPositionHistoryDTO {
	
	@NotNull(message = "{campo.codigo-equipment.obrigatorio}")	
	private UUID equipmentId;
	
	private LocalDateTime date;
	private Float lat;
	private Float lon;

}
