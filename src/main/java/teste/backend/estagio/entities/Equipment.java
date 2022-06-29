package teste.backend.estagio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "equipment", schema = "operation")
public class Equipment implements Serializable{

	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModel equipmentModel;
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Set<EquipmentPositionHistory> positions = new HashSet<>();
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Set<EquipmentStateHistory> stateHistory = new HashSet<>();
	
	
	
	public Equipment() {
		
	}

	public Equipment(EquipmentModel equipmentModel, UUID id, String name) {
		super();
		this.equipmentModel = equipmentModel;
		this.id = id;
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

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}
	
	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
}
