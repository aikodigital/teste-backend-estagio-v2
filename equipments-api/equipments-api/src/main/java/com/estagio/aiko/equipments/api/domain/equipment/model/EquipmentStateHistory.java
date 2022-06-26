package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipmentStateHistoryId id;

	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	public EquipmentStateHistory() {
	}

	public EquipmentStateHistoryId getId() {
		return id;
	}

	public void setId(EquipmentStateHistoryId id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id);
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
		return Objects.equals(date, other.date) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EquipmentStateHistory [id=" + id + ", date=" + date + "]";
	}

}
