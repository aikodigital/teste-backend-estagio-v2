package com.vitor.forestequipment.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
	private EquipmentModel model;

	@OneToMany(mappedBy = "equipmentPositionHistoryId.equipment", cascade = CascadeType.ALL)
	List<EquipmentPositionHistory> positionHistory = new ArrayList<>();

	@OneToMany(mappedBy = "equipmentStateHistoryId.equipment", cascade = CascadeType.ALL)
	List<EquipmentStateHistory> stateHistory = new ArrayList<>();

	public List<EquipmentStateHistory> getStateHistory() {
		return stateHistory;
	}

	public void setStateHistory(List<EquipmentStateHistory> stateHistory) {
		this.stateHistory = stateHistory;
	}

	public List<EquipmentPositionHistory> getPositionHistory() {
		return positionHistory;
	}

	public void setPositionHistory(List<EquipmentPositionHistory> positionHistory) {
		this.positionHistory = positionHistory;
	}

	public Equipment() {

	}

	public Equipment(UUID id, String name, EquipmentModel model) {
		super();
		this.id = id;
		this.name = name;
		this.setModel(model);
	}

	public Equipment(UUID id) {
		this.id = id;
	}

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

	public EquipmentModel getModel() {
		return model;
	}

	public void setModel(EquipmentModel model) {
		this.model = model;
	}

}
