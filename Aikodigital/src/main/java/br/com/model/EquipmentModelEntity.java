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
 * Classe de persistência que representa os modelos dos equipamentos
 * @author Danillo Santiago 
 * @since jun 2022
 */
@Entity
@Table(name = "equipment_model", schema = "operation")
public class EquipmentModelEntity {

	/**
	 * Atributo de identificação de modelo do equipamento de tipo UUID
	 */
	@Id
	private UUID id = UUID.randomUUID();

	/**
	 * Atributo de nome do modelo do equipamento de  tipo String
	 */
	private String name;

	/**
	 * Relacionamento um (modelo de equipamento) para muitos (equipamentos) que retorna uma lista
	 * de equipamentos referenciados pelo ID do modelo 
	 */
	@OneToMany(mappedBy = "equipmentModel", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentEntity> equipmentEntities = new ArrayList<EquipmentEntity>();

	/**
	 * Relacionamento um (modelo de equipamento) para muitos ( valor por hora do modelo de equipamento em cada estado)
	 *  que retorna uma lista de valores referenciados pelo ID do modelo
	 */
	@OneToMany(mappedBy = "equipmentModelEarnings", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentModelStateHourlyEarningsEntity> hourlyEarningsEntities = new ArrayList<EquipmentModelStateHourlyEarningsEntity>();

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EquipmentEntity> getEquipmentEntities() {
		return equipmentEntities;
	}

	public void setEquipmentEntities(List<EquipmentEntity> equipmentEntities) {
		this.equipmentEntities = equipmentEntities;
	}

	public void setHourlyEarningsEntities(List<EquipmentModelStateHourlyEarningsEntity> hourlyEarningsEntities) {
		this.hourlyEarningsEntities = hourlyEarningsEntities;
	}

	public List<EquipmentModelStateHourlyEarningsEntity> getHourlyEarningsEntities() {
		return hourlyEarningsEntities;
	}

}
