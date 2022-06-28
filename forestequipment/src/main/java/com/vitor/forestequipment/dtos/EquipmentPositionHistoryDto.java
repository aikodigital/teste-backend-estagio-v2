package com.vitor.forestequipment.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class EquipmentPositionHistoryDto {

	private UUID equipment;

	private double lat;

	private double lon;
	
	private LocalDateTime date;

	public UUID getEquipment() {
		return equipment;
	}

	public void setEquipment(UUID equipment) {
		this.equipment = equipment;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}


}
