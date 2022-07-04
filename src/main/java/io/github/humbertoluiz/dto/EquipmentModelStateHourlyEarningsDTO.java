package io.github.humbertoluiz.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
public class EquipmentModelStateHourlyEarningsDTO {
	
	@NotNull(message = "{campo.codigo-equipmentModel.obrigatorio}")
	private UUID equipmentModelId;
	
	@NotNull(message = "{campo.codigo-equipmentState.obrigatorio}")
	private UUID equipmentStateId;
	
	@NotNull(message = "{campo.value.obrigatorio}")
	private Float value;
	
	public EquipmentModelStateHourlyEarningsDTO() {}

	public EquipmentModelStateHourlyEarningsDTO(Float value) {
		this.value = value;
	}

	public UUID getEquipmentModelId() {
		return equipmentModelId;
	}

	public void setEquipmentModelId(UUID equipmentModelId) {
		this.equipmentModelId = equipmentModelId;
	}

	public UUID getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(UUID equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
}
