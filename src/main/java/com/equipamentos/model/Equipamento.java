package com.equipamentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="equipment")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	@Column(name="name")
	private String nome;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@Column(name="equipment_model_id")
	private ModeloEquipamento modeloEquipamento;
	
	public Equipamento() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public ModeloEquipamento getModeloEquipamento() {
		return modeloEquipamento;
	}

	public void setModeloEquipamento(ModeloEquipamento modeloEquipamento) {
		this.modeloEquipamento = modeloEquipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Equipamento other = (Equipamento) obj;
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
