package br.com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe de persistência que representa os estados de equipamento
 * @author Danillo Santiago
 * @since jun 2022
 */
@Entity
@Table(name = "equipment_state", schema = "operation")
public class EquipmentStateEntity {

	/**
	 * Atributo de identificação do estado do tipo UUID
	 */
	@Id
	private UUID id = UUID.randomUUID();

	/**
	 * Atributo nome do estado do tipo String
	 */
	private String name;

	/**
	 * Atributo cor do estado de equipamento
	 */
	private String color;

	/**
	 * Relacionamento um (estado de equipamento) para muitos (histórico de estado de equipamento) que retorna
	 * uma lista de histórico de estado de equipamento
	 */
	@OneToMany(mappedBy = "equipmentState", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentStateHistoryEntity> stateHistoryEntities = new ArrayList<EquipmentStateHistoryEntity>();

	/**
	 * Relacionamento um (estado de equipamento) para muitos (Valor por hora de modelo de equipamento em cada estado) que
	 * retorn uma lista de  valores por hora de modelo  de equipamento em cada estado 
	 */
	@OneToMany(mappedBy = "equipmentStateEarnings", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentModelStateHourlyEarningsEntity> hourlyEarningsEntities = new ArrayList<EquipmentModelStateHourlyEarningsEntity>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setStateHistoryEntities(List<EquipmentStateHistoryEntity> stateHistoryEntities) {
		this.stateHistoryEntities = stateHistoryEntities;
	}

	public List<EquipmentStateHistoryEntity> getStateHistoryEntities() {
		return stateHistoryEntities;
	}

	public void setHourlyEarningsEntities(List<EquipmentModelStateHourlyEarningsEntity> hourlyEarningsEntities) {
		this.hourlyEarningsEntities = hourlyEarningsEntities;
	}

	public List<EquipmentModelStateHourlyEarningsEntity> getHourlyEarningsEntities() {
		return hourlyEarningsEntities;
	}

}
