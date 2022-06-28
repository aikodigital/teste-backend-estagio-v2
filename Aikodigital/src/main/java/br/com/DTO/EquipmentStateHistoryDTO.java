package br.com.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.model.EquipmentStateHistoryEntity;

/**
 * Classe EquipmentStateHistoryDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago
 * @since jun 2022
 */
public class EquipmentStateHistoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731588162212627875L;

	/**
	 * Atributo de identificação do equipamento
	 */
	private UUID equipmentId;

	/**
	 * Atributo de data do histórico do estado
	 */
	private LocalDateTime date;

	/**
	 * Atributo de identificação do estado de equipamento
	 */
	private UUID equipmentStateId;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentStateHistoryEntity
	 */
	public EquipmentStateHistoryDTO(EquipmentStateHistoryEntity stateHistoryEntity) {
		this.equipmentId = stateHistoryEntity.getEquipment1().getId();
		this.date = stateHistoryEntity.getDate();
		this.equipmentStateId = stateHistoryEntity.getEquipmentstate().getId();
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public UUID getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(UUID equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

}
