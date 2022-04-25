package com.equipamentos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
//nomes das entidades iguais ao do banco
//assim como os atributos
public class IdHistoricoEstadoEquipamento implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    @Column(name="equipment_id")
	private Long idEquipamento;

    @Column(name="equipment_state_id")
	private Long idEstadoEquipamento;
	
	public IdHistoricoEstadoEquipamento() {
	}

	public IdHistoricoEstadoEquipamento(Long idEquipamento, Long idEstadoEquipamento) {
		super();
		this.idEquipamento = idEquipamento;
		this.idEstadoEquipamento = idEstadoEquipamento;
	}

	public Long getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Long idEquipamento) {
		this.idEquipamento = idEquipamento;
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
		result = prime * result + ((idEquipamento == null) ? 0 : idEquipamento.hashCode());
		result = prime * result + ((idEstadoEquipamento == null) ? 0 : idEstadoEquipamento.hashCode());
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
		IdHistoricoEstadoEquipamento other = (IdHistoricoEstadoEquipamento) obj;
		if (idEquipamento == null) {
			if (other.idEquipamento != null)
				return false;
		} else if (!idEquipamento.equals(other.idEquipamento))
			return false;
		if (idEstadoEquipamento == null) {
			if (other.idEstadoEquipamento != null)
				return false;
		} else if (!idEstadoEquipamento.equals(other.idEstadoEquipamento))
			return false;
		return true;
	}
}
