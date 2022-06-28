package digital.aiko.teste.model.entities;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "operation", name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "equipment_model_id", nullable = false)
	private EquipmentModel equipmentModelId;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	public Equipment() {

	}

	public Equipment(UUID id) {

		this.id = id;
	}

	public Equipment(EquipmentModel equipmentModelId, String name) {
		this.equipmentModelId = equipmentModelId;
		this.name = name;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModelId = equipmentModel;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModelId;
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
