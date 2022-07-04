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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

	@NotBlank(message = "{campo.name.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
	private EquipmentModel equipmentModel;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EquipmentStateHistory> equipmentStateHistory = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="equipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EquipmentPositionHistory> equipmentPositionHistory = new HashSet<>();
	
	public Equipment() {}

	public Equipment(String name, EquipmentModel equipmentModel, Set<EquipmentStateHistory> equipmentStateHistory,
			Set<EquipmentPositionHistory> equipmentPositionHistory) {
		this.name = name;
		this.equipmentModel = equipmentModel;
		this.equipmentStateHistory = equipmentStateHistory;
		this.equipmentPositionHistory = equipmentPositionHistory;
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

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public Set<EquipmentStateHistory> getEquipmentStateHistory() {
		return equipmentStateHistory;
	}

	public void setEquipmentStateHistory(Set<EquipmentStateHistory> equipmentStateHistory) {
		this.equipmentStateHistory = equipmentStateHistory;
	}

	public Set<EquipmentPositionHistory> getEquipmentPositionHistory() {
		return equipmentPositionHistory;
	}

	public void setEquipmentPositionHistory(Set<EquipmentPositionHistory> equipmentPositionHistory) {
		this.equipmentPositionHistory = equipmentPositionHistory;
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
		Equipment other = (Equipment) obj;
		return Objects.equals(id, other.id);
	}
	
}
