package br.com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

	/**
	 * Classe de persistência que representa os equipamentos
	 * @author Danillo Santiago
	 * @since jun 2022
	 */
@Entity
@Table(name = "equipment", schema = "operation")
public class EquipmentEntity {

	/**
	 * Atributo de identificação de equipamento de tipo UUID
	 */
	@Id
	private UUID id = UUID.randomUUID();

	/**
	 * Atributo de nome do equipamento de  tipo String
	 */
	private String name;

	/**
	 * Relacionamento de entidade de tipo muitos (equipamentos) para um (modelo), sendo a chave estrangeira
	 * o id do modelo de equipamento  
	 */
	@ManyToOne(optional = false)
	@ForeignKey(name = "equipment_model_id")
	private EquipmentModelEntity equipmentModel;

	/**
	 * Relacionamento um (equipamento) para muitos (histórico de estados), que retorna uma lista do histórico
	 * de estados do equipamento referenciado 
	 */
	@OneToMany(mappedBy = "equipment1", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentStateHistoryEntity> stateHistoryEntities = new ArrayList<EquipmentStateHistoryEntity>();

	/**
	 * Relacionamento um (equipamento) para muitos (histórico de posições do equipamento) que retorna uma lista do histórico
	 * de posições do equipamento
	 */
	@OneToMany(mappedBy = "equipmentPosition", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<EquipmentPositionHistoryEntity> positionHistoryEntities = new ArrayList<EquipmentPositionHistoryEntity>();

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

	public void setEquipmentModel(EquipmentModelEntity equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public EquipmentModelEntity getEquipmentModel() {
		return equipmentModel;
	}

	public void setPositionHistoryEntities(List<EquipmentPositionHistoryEntity> positionHistoryEntities) {
		this.positionHistoryEntities = positionHistoryEntities;
	}

	public List<EquipmentPositionHistoryEntity> getPositionHistoryEntities() {
		return positionHistoryEntities;
	}

	public void setStateHistoryEntities(List<EquipmentStateHistoryEntity> stateHistoryEntities) {
		this.stateHistoryEntities = stateHistoryEntities;
	}

	public List<EquipmentStateHistoryEntity> getStateHistoryEntities() {
		return stateHistoryEntities;
	}

}
