package br.com.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Classe de persistência que representa os valores por hora de modelos de equipamentos em cada estado
 * @author Danillo Santiago
 * @since jun 2022
 */
@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarningsEntity {

	/**
	 * Mapeamento da classe com as chaves estrangeiras de modelo ID e estado ID
	 */
	@EmbeddedId
	private EquipmentModelStateHourlyEarningsPK hourlyEarningsPK = new EquipmentModelStateHourlyEarningsPK();

	/**
	 * Relacionamento e mapeamento com a chave estrangeira do estado de equipamento
	 */
	@MapsId("equipmentStateId")
	@ManyToOne
	@JoinColumn(name = "equipmentStateId", referencedColumnName = "id")
	private EquipmentStateEntity equipmentStateEarnings;

	/**
	 * Relacionamento e mapeamento com a chave estrangeira do modelo de equipamento
	 */
	@MapsId("equipmentModelId")
	@ManyToOne
	@JoinColumn(name = "equipmentModelId", referencedColumnName = "id")
	private EquipmentModelEntity equipmentModelEarnings;

	/**
	 * Atributo de valor de ganhos por hora do tipo real
	 */
	private float value;

	public EquipmentStateEntity getEquipmentStateEarnings() {
		return equipmentStateEarnings;
	}

	public void setEquipmentStateEarnings(EquipmentStateEntity equipmentStateEarnings) {
		this.equipmentStateEarnings = equipmentStateEarnings;
	}

	public void setEquipmentModelEarnings(EquipmentModelEntity equipmentModelEarnings) {
		this.equipmentModelEarnings = equipmentModelEarnings;
	}

	public EquipmentModelEntity getEquipmentModelEarnings() {
		return equipmentModelEarnings;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
