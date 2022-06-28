package br.com.DTO;

import java.io.Serializable;
import java.util.UUID;

import br.com.model.EquipmentEntity;
/**
 * Classe EquipmentDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago
 * @since jun 2022
 */
public class EquipmentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de identificação da classe do tipo UUID
	 */
	private UUID id;

	/**
	 * Atributo de identificação do modelo de equipamento
	 */
	private UUID equipmentModelId;

	/**
	 * Nome  do equipamento
	 */
	private String nameModelEquipment;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentEntity
	 */
	public EquipmentDTO(EquipmentEntity equipmentEntity) {
		this.id = equipmentEntity.getId();
		this.equipmentModelId = equipmentEntity.getEquipmentModel().getId();
		this.nameModelEquipment = equipmentEntity.getName();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getEquipmentModelId() {
		return equipmentModelId;
	}

	public void setEquipmentModelId(UUID equipmentModelId) {
		this.equipmentModelId = equipmentModelId;
	}

	public void setNameModelEquipment(String nameModelEquipment) {
		this.nameModelEquipment = nameModelEquipment;
	}

	public String getNameModelEquipment() {
		return nameModelEquipment;
	}

}
