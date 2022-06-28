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
@Table(schema = "operation", name = "equipment_state")
public class EquipmentState implements Serializable {

	private static final long serialVersionUID = 4776405197654542226L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "color", nullable = false)
	private String color;

	public EquipmentState() {

	}

	public EquipmentState(UUID id) {
		this.id = id;
	}

	public EquipmentState(UUID id, String name, String color) {

		this.id = id;
		this.name = name;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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

}
