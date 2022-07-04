package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotNull(message = "{campo.date.obrigatorio}")
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime date;
	
	@NotNull(message = "{campo.lat.obrigatorio}")
	@Column(nullable = false)
	private Float lat;
	
	@NotNull(message = "{campo.lon.obrigatorio}")
	@Column(nullable = false)
	private Float lon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id", referencedColumnName = "id")
	private Equipment equipment;
	
	public EquipmentPositionHistory() {}

	public EquipmentPositionHistory(LocalDateTime date, Float lat, Float lon) {
		this.date = date;
		this.lat = lat;
		this.lon = lon;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentPositionHistory other = (EquipmentPositionHistory) obj;
		return Objects.equals(id, other.id);
	}

}
