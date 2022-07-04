package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
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
@Table(name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotNull(message = "{campo.value.obrigatorio}")
	@Column(nullable = false)
	private Float value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
	private EquipmentState equipmentState;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
	private EquipmentModel equipmentModel;
	
	public EquipmentModelStateHourlyEarnings () {}

	public EquipmentModelStateHourlyEarnings (Float value, EquipmentState equipmentState, EquipmentModel equipmentModel) {
		this.value = value;
		this.equipmentState = equipmentState;
		this.equipmentModel = equipmentModel;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
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
		EquipmentModelStateHourlyEarnings other = (EquipmentModelStateHourlyEarnings) obj;
		return Objects.equals(id, other.id);
	}

}
