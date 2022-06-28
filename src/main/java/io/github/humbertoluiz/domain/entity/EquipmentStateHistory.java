package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull(message = "{campo.date.obrigatorio}")
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
	private EquipmentState equipmentState;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_id", referencedColumnName = "id")
	private Equipment equipment;

	@Builder
	public EquipmentStateHistory(LocalDateTime date, EquipmentState equipmentState, Equipment equipment) {
		this.date = date;
		this.equipment = equipment;
		this.equipmentState = equipmentState;
	}
		
}
