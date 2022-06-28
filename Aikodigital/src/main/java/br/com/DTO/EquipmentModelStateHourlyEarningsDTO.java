package br.com.DTO;

import java.io.Serializable;
import java.util.UUID;

import br.com.model.EquipmentModelStateHourlyEarningsEntity;

/**
 * Classe EquipmentModelStateHourlyEarningsDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago
 * @since jun 2022
 */
public class EquipmentModelStateHourlyEarningsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1363615962073373734L;

	/**
	 * Atributo de identificação do modelo de equipamento
	 */
	private UUID equipmentModelId;

	/**
	 * Atributo de identificação do estado de equipamento
	 */
	private UUID equipmentStateId;

	/**
	 * Valor do modelo de equipamento em cada estado
	 */
	private float earningValue;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentModelStateHourlyEarningsEntity
	 */
	public EquipmentModelStateHourlyEarningsDTO(
			EquipmentModelStateHourlyEarningsEntity modelStateHourlyEarningsEntity) {
		this.equipmentModelId = modelStateHourlyEarningsEntity.getEquipmentModelEarnings().getId();
		this.equipmentStateId = modelStateHourlyEarningsEntity.getEquipmentStateEarnings().getId();
		this.earningValue = modelStateHourlyEarningsEntity.getValue();
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

	public void setEarningValue(float earningValue) {
		this.earningValue = earningValue;
	}

	public float getEarningValue() {
		return earningValue;
	}

}
