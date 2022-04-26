package com.equipamentos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
//nomes das entidades iguais ao do banco
//assim como os atributos
@Table(name="equipment_state_history")
public class HistoricoEstadoEquipamento {

	@EmbeddedId
	private HistoricoEstadoEquipamento id = new HistoricoEstadoEquipamento();
	
	@ManyToOne
	@MapsId("equipment_id")
	@Column(name="equipment_id")
	private Equipamento equipamento;
	
	@ManyToOne  
	@MapsId("equipment_state_id")
	@Column(name="equipment_state_id")
	private EstadoEquipamento estadoEquipamento;
	
	@Column(name="date")
	private Date data;
	
	public HistoricoEstadoEquipamento() {
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public EstadoEquipamento getEstadoEquipamento() {
		return estadoEquipamento;
	}

	public void setEstadoEquipamento(EstadoEquipamento estadoEquipamento) {
		this.estadoEquipamento = estadoEquipamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((estadoEquipamento == null) ? 0 : estadoEquipamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoEstadoEquipamento other = (HistoricoEstadoEquipamento) obj;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (estadoEquipamento == null) {
			if (other.estadoEquipamento != null)
				return false;
		} else if (!estadoEquipamento.equals(other.estadoEquipamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
