package com.equipamentos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="equipment_position_history")
public class HistoricoPosicaoEquipamento {

	@Column(name="date")
	private Date data;
	
	@Column(name="lat")
	private String latitude;
	
	@Column(name="lon")
	private String longitude;

	@EmbeddedId
	@ManyToOne
	@Column(name="equipment_id")
	private Equipamento Equipamento;
	
	public HistoricoPosicaoEquipamento() {
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Equipamento getEquipamento() {
		return Equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		Equipamento = equipamento;
	}
	 	
}
