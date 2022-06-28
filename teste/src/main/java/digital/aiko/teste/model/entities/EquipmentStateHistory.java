package digital.aiko.teste.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "operation", name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable{

		private static final long serialVersionUID = 6624372157785936044L;

	@EmbeddedId
	private ModelStateHistoryId id;
	
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	public EquipmentStateHistory() {
		
	}

	public ModelStateHistoryId getId() {
		return id;
	}

	public void setId(ModelStateHistoryId id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
