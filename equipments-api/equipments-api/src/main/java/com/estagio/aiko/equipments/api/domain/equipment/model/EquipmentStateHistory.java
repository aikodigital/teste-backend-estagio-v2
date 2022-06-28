package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id")
	private UUID id;

	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentState state;

	public EquipmentStateHistory() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public EquipmentState getState() {
		return state;
	}

	public void setState(EquipmentState state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, equipment, id, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistory other = (EquipmentStateHistory) obj;
		return Objects.equals(date, other.date) && Objects.equals(equipment, other.equipment)
				&& Objects.equals(id, other.id) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "EquipmentStateHistory [id=" + id + ", date=" + date + ", equipment=" + equipment + ", state=" + state
				+ "]";
	}

}
