package com.equipamentos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
//nomes das entidades iguais ao do banco
//assim como os atributos
public class IdEstadoModeloValorEquipamento implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Column(name="equipment_model_id")
	private Long idModeloEquipamento;
    
    @Column(name="equipment_state_id")
	private Long idEstadoEquipamento;
	
	public IdEstadoModeloValorEquipamento() {
	}

	public IdEstadoModeloValorEquipamento(Long idModeloEquipamento, Long idEstadoEquipamento) {
		super();
		this.idModeloEquipamento = idModeloEquipamento;
		this.idEstadoEquipamento = idEstadoEquipamento;
	}

	public Long getIdModeloEquipamento() {
		return idModeloEquipamento;
	}

	public void setIdModeloEquipamento(Long idModeloEquipamento) {
		this.idModeloEquipamento = idModeloEquipamento;
	}

	public Long getIdEstadoEquipamento() {
		return idEstadoEquipamento;
	}

	public void setIdEstadoEquipamento(Long idEstadoEquipamento) {
		this.idEstadoEquipamento = idEstadoEquipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstadoEquipamento == null) ? 0 : idEstadoEquipamento.hashCode());
		result = prime * result + ((idModeloEquipamento == null) ? 0 : idModeloEquipamento.hashCode());
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
		IdEstadoModeloValorEquipamento other = (IdEstadoModeloValorEquipamento) obj;
		if (idEstadoEquipamento == null) {
			if (other.idEstadoEquipamento != null)
				return false;
		} else if (!idEstadoEquipamento.equals(other.idEstadoEquipamento))
			return false;
		if (idModeloEquipamento == null) {
			if (other.idModeloEquipamento != null)
				return false;
		} else if (!idModeloEquipamento.equals(other.idModeloEquipamento))
			return false;
		return true;
	}

}
