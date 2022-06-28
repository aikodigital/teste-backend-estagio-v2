package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "equipment_state")
public class EquipmentState implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank(message = "{campo.name.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String name;
	
	@NotBlank(message = "{campo.color.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String color;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipmentState", cascade = CascadeType.ALL)
	private Set<EquipmentStateHistory> equipmentStateHistory = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="equipmentState", cascade = CascadeType.ALL)
	private Set<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings = new HashSet<>();
	
	@Builder
	public EquipmentState(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
}


