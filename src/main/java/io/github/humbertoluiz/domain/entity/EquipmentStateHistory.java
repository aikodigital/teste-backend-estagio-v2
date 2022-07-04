package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull(message = "{campo.date.obrigatorio}")
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
	private EquipmentState equipmentState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id", referencedColumnName = "id")
	private Equipment equipment;

	public EquipmentStateHistory() {}
	
	public EquipmentStateHistory(LocalDateTime date, EquipmentState equipmentState, Equipment equipment) {
		this.date = date;
		this.equipment = equipment;
		this.equipmentState = equipmentState;
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

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

}
