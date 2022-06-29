package teste.backend.estagio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_model", schema = "operation")
public class EquipmentModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private String name;
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "id.equipmentModel", fetch = FetchType.LAZY)
	private Set<EquipmentModelStateHourlyEarnings> earnings = new HashSet<>();
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "equipmentModel", fetch = FetchType.LAZY)
	private List<Equipment> equipment;
	
	public EquipmentModel() {
		
	}

	public EquipmentModel(UUID id, String name) {
		super();
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
	
}
