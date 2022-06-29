package com.brunopereira.projetoaiko.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.brunopereira.projetoaiko.entities.enums.EquipmentState;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	private EquipmentState equipmentState;

	public EquipmentStateHistory() {
	}

	public EquipmentStateHistory(Long id, Date date, Equipment equipment, EquipmentState equipmentState) {
		this.id = id;
		this.date = date;
		this.equipment = equipment;
		this.equipmentState = equipmentState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

}
