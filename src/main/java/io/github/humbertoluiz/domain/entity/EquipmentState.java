package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "equipment_state")
public class EquipmentState implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank(message = "{campo.name.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String name;
	
	@NotBlank(message = "{campo.color.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String color;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipmentState", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EquipmentStateHistory> equipmentStateHistory = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="equipmentState", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings = new HashSet<>();
	
	public EquipmentState() {}
	
	public EquipmentState(String name, String color) {
		this.name = name;
		this.color = color;
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

	public Set<EquipmentStateHistory> getEquipmentStateHistory() {
		return equipmentStateHistory;
	}

	public void setEquipmentStateHistory(Set<EquipmentStateHistory> equipmentStateHistory) {
		this.equipmentStateHistory = equipmentStateHistory;
	}

	public Set<EquipmentModelStateHourlyEarnings> getEquipmentModelStateHourlyEarnings() {
		return equipmentModelStateHourlyEarnings;
	}

	public void setEquipmentModelStateHourlyEarnings(
			Set<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings) {
		this.equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarnings;
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
		EquipmentState other = (EquipmentState) obj;
		return Objects.equals(id, other.id);
	}

}


