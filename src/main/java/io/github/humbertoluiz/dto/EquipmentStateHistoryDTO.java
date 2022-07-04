package io.github.humbertoluiz.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;

public class EquipmentStateHistoryDTO {
	
	@NotNull(message = "{campo.codigo-equipment.obrigatorio}")	
	private UUID equipmentId;
	
	@NotNull(message = "{campo.codigo-equipmentState.obrigatorio}")
	private UUID equipmentStateId;

	@NotNull(message = "{campo.date.obrigatorio}")
	private LocalDateTime date;
	
	public EquipmentStateHistoryDTO() {}
	
	public EquipmentStateHistoryDTO(LocalDateTime date) {
		this.date = date;
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	public UUID getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(UUID equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
