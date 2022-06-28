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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_state")
public class EquipmentState {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private String color;

	public EquipmentState() {
	}

	public EquipmentState(UUID id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public EquipmentState(UUID equipmentStateId) {
		this.id = equipmentStateId;
	}

	@OneToMany(mappedBy = "equipmentStateHistoryId.equipment", cascade = CascadeType.ALL)
	List<EquipmentStateHistory> stateHistory = new ArrayList<>();

	public List<EquipmentStateHistory> getStateHistory() {
		return stateHistory;
	}

	public void setStateHistory(List<EquipmentStateHistory> stateHistory) {
		this.stateHistory = stateHistory;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
