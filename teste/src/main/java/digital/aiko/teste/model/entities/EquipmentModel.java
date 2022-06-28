package digital.aiko.teste.model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "operation", name = "equipment_model")
public class EquipmentModel implements Serializable {

	private static final long serialVersionUID = 558120232118090445L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	public EquipmentModel() {

	}

	public EquipmentModel(String name) {
		this.name = name;
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

}
