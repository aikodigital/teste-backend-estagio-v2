package br.com.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

/**
 * Classe responsável pelas chaves estrangeiras que são embutidas na classe EquipamentStateHistory
 * @author Danillo Santiago
 * @since jun 2022
 */
@Embeddable
public class EquipmentStateHistoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 360916338859030806L;

	/**
	 * Atributo de chave estrangeira da classe de equipamento do tipo UUID
	 */
	private UUID equipmentId = UUID.randomUUID();

	/**
	 * Atributo de chave estrangeira da classe estado de equipamento do tipo UUID
	 */
	private UUID equipmentStateId = UUID.randomUUID();

	public EquipmentStateHistoryPK() {

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

	/**
	 * Geração do método de HashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(equipmentId, equipmentStateId);
	}

	/**
	 * Geração do método de Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistoryPK other = (EquipmentStateHistoryPK) obj;
		return Objects.equals(equipmentId, other.equipmentId)
				&& Objects.equals(equipmentStateId, other.equipmentStateId);
	}

}
