package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class EquipmentPositionHistoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	public EquipmentPositionHistoryId() {
	}

	public EquipmentPositionHistoryId(@NotNull LocalDateTime date, @NotNull Equipment equipment) {
		this.date = date;
		this.equipment = equipment;
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

	@Override
	public int hashCode() {
		return Objects.hash(date, equipment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistoryId other = (EquipmentPositionHistoryId) obj;
		return Objects.equals(date, other.date) && Objects.equals(equipment, other.equipment);
	}

	@Override
	public String toString() {
		return "EquipmentPositionHistoryId [date=" + date + ", equipment=" + equipment + "]";
	}

}
