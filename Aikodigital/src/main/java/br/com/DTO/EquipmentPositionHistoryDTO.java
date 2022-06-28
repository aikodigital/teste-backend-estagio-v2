package br.com.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.model.EquipmentPositionHistoryEntity;

/**
 * Classe EquipmentPositionHistoryDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago
 * @since jun 2022
 */
public class EquipmentPositionHistoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4480551824677110846L;

	/**
	 * Atributo de identificação do equipamento
	 */
	private UUID equipmentId;

	/**
	 * Atributo de data da posição no histórico
	 */
	private LocalDateTime datePositionHistory;

	/**
	 * Atributo de latitude da posição
	 */
	private float latitude;

	/**
	 * Atributo de longitude da posição
	 */
	private float longitude;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentPositionHistoryEntity
	 */
	public EquipmentPositionHistoryDTO(EquipmentPositionHistoryEntity positionHistoryEntity) {
		this.equipmentId = positionHistoryEntity.getEquipmentPosition().getId();
		this.datePositionHistory = positionHistoryEntity.getDate();
		this.latitude = positionHistoryEntity.getLat();
		this.longitude = positionHistoryEntity.getLon();
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setDatePositionHistory(LocalDateTime datePositionHistory) {
		this.datePositionHistory = datePositionHistory;
	}
	
	public LocalDateTime getDatePositionHistory() {
		return datePositionHistory;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
