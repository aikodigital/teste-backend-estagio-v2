package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotNull(message = "{campo.value.obrigatorio}")
	@Column(nullable = false)
	private Float value;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
	private EquipmentState equipmentState;	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
	private EquipmentModel equipmentModel;

	@Builder
	public EquipmentModelStateHourlyEarnings(Float value) {
		this.value = value;
	}
		
}
