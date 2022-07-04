package io.github.humbertoluiz.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;

public class EquipmentPositionHistoryDTO {
	
	@NotNull(message = "{campo.codigo-equipment.obrigatorio}")	
	private UUID equipmentId;	
	
	private LocalDateTime date;
	private Float lat;
	private Float lon;
	
	public EquipmentPositionHistoryDTO() {
		super();
	}

	public EquipmentPositionHistoryDTO(LocalDateTime date, Float lat, Float lon) {
		this.date = date;
		this.lat = lat;
		this.lon = lon;
	}

	public UUID getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(UUID equipmentId) {
		this.equipmentId = equipmentId;
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

}
