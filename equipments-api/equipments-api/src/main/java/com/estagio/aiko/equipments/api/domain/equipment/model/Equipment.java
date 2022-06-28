package com.estagio.aiko.equipments.api.domain.equipment.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equipment", schema = "operation")
public class Equipment implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id")
	private UUID id;

	@NotBlank
	@Column(name = "name")
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel model;

	public Equipment() {
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

	public EquipmentModel getModel() {
		return model;
	}

	public void setModel(EquipmentModel model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, model, name);
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
		return Objects.equals(id, other.id) && Objects.equals(model, other.model) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", model=" + model + "]";
	}

}
