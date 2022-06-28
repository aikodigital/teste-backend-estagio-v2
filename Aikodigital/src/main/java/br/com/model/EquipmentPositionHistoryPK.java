package br.com.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

/**
 * Classe responsável pela chave estrangeira que é embutida na classe EquipmentPositionHistory
 * @author Danillo Santiago
 * @since jun 2022
 */
@Embeddable
public class EquipmentPositionHistoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8940640928873721542L;

	/**
	 * Atributo de chave estrangeira do equipamento ID do tipo UUID
	 */
	private UUID equipmentId = UUID.randomUUID();

	/**
	 * Construtor vazio da classe
	 */
	public EquipmentPositionHistoryPK() {

	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * Geração do método de HashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(equipmentId);
	}

	/**
	 * Geração do método Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistoryPK other = (EquipmentPositionHistoryPK) obj;
		return Objects.equals(equipmentId, other.equipmentId);
	}

}
