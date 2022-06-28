package digital.aiko.teste.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "operation", name = "equipment_position_history")
public class EquipmentPositionHistory implements Serializable{


	private static final long serialVersionUID = 1339465269074454995L;

	@Id
   	private UUID id;

	@ManyToOne
    @JoinColumn(name = "equipment_id")
	@MapsId
    private  Equipment equipment;
		
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "lat")
	private BigDecimal lat;
	
	@Column(name = "lon")
	private BigDecimal lon;
	
	public EquipmentPositionHistory() {
		
	}
	
	
public EquipmentPositionHistory(Equipment equipment, Date date, BigDecimal lat, BigDecimal lon) {
		
		this.equipment = equipment;
		this.date = date;
		this.lat = lat;
		this.lon = lon;
	}


	public UUID getId() {
		return id;
	}


	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
	
	
}
