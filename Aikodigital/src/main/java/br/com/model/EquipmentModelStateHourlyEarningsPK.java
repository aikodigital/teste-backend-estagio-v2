package br.com.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

/**
 * Classe responsável pelas chaves estrangeiras que são embutidas na classe
 * EquipmentModelStateHourlyEarnings  
 * @author Danillo Santiago 
 * @since jun 2022
 *
 */
@Embeddable
public class EquipmentModelStateHourlyEarningsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4001561981165323379L;

	/**
	 * Atributo de chave estrangeira da classe modelo de equipamento do tipo UUID
	 */
	private UUID equipmentModelId = UUID.randomUUID();

	/**
	 * Atributo de chave estrangeira da classe estado de equipamento do tipo UUID
	 */
	private UUID equipmentStateId = UUID.randomUUID();

	/**
	 * Construtor vazio da classe 
	 */
	public EquipmentModelStateHourlyEarningsPK() {

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

	@Override
	public int hashCode() {
		return Objects.hash(equipmentModelId, equipmentStateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentModelStateHourlyEarningsPK other = (EquipmentModelStateHourlyEarningsPK) obj;
		return Objects.equals(equipmentModelId, other.equipmentModelId)
				&& Objects.equals(equipmentStateId, other.equipmentStateId);
	}

}
