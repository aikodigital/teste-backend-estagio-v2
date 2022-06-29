package com.brunopereira.projetoaiko.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.brunopereira.projetoaiko.entities.enums.EquipmentState;

@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class ValuePerHour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="price")
	private Double value;
	
	@OneToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;
	
	private EquipmentState equipmentState;

	public ValuePerHour() {
	}

	public ValuePerHour(Long id, EquipmentModel equipmentModel, EquipmentState equipmentState, Double value) {
		this.id = id;
		this.value = value;
		this.equipmentModel = equipmentModel;
		this.equipmentState = equipmentState;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}
	
}
