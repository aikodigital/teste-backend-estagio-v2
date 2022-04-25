package com.equipamentos.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
//nomes das entidades iguais ao do banco
//assim como os atributos
@Table(name="equipment_model_state_hourly_earnings")
public class EstadoModeloValorEquipamento {

	@EmbeddedId
	private EstadoModeloValorEquipamento id = new EstadoModeloValorEquipamento();
	
	@ManyToOne
	@MapsId("equipment_model_id")
	@Column(name="equipment_model_id")
	private ModeloEquipamento modeloEquipamento;
	
	@ManyToOne  
	@MapsId("equipment_state_id")
	@Column(name="equipment_state_id")
	private EstadoEquipamento estadoEquipamento;
	
	@Column(name="value")
	private Double valor;
	
	public EstadoModeloValorEquipamento() {
	}

	public ModeloEquipamento getModeloEquipamento() {
		return modeloEquipamento;
	}

	public void setModeloEquipamento(ModeloEquipamento modeloEquipamento) {
		this.modeloEquipamento = modeloEquipamento;
	}

	public EstadoEquipamento getEstadoEquipamento() {
		return estadoEquipamento;
	}

	public void setEstadoEquipamento(EstadoEquipamento estadoEquipamento) {
		this.estadoEquipamento = estadoEquipamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoEquipamento == null) ? 0 : estadoEquipamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modeloEquipamento == null) ? 0 : modeloEquipamento.hashCode());
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
		EstadoModeloValorEquipamento other = (EstadoModeloValorEquipamento) obj;
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
		if (modeloEquipamento == null) {
			if (other.modeloEquipamento != null)
				return false;
		} else if (!modeloEquipamento.equals(other.modeloEquipamento))
			return false;
		return true;
	}
}
