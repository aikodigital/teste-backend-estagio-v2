package digital.aiko.teste.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "operation", name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings {

	@EmbeddedId
	private ModelStateHourlyEarningsId id;
	
	@Column(name = "value", nullable = false)
	private BigDecimal value;
	
	public EquipmentModelStateHourlyEarnings() {
		
	}

	public ModelStateHourlyEarningsId getId() {
		return id;
	}

	public void setId(ModelStateHourlyEarningsId id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
