package br.com.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe de persistência que representa o histórico de posições do equipamento 
 * @author Danillo Santiago
 * @since jun 2022
 */
@Entity
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistoryEntity {

	/**
	 * Mapeamento da classe com a chave estrangeira de equipamento ID
	 */
	@EmbeddedId
	private EquipmentPositionHistoryPK positionHistoryPK = new EquipmentPositionHistoryPK();

	/**
	 * Relacionamento e mapeamento com a chave estrangeira de equipamento
	 */
	@MapsId("equipmentId")
	@ManyToOne
	@JoinColumn(name = "equipmentId", referencedColumnName = "id")
	private EquipmentEntity equipmentPosition;

	/**
	 * Atributo da data da posição do tipo Date 
	 */
	
	private LocalDateTime date;

	/**
	 * Atributo de latitude da posição do equipamento
	 */
	private float lat;

	/**
	 * Atributo de longitude da posição do equipamento
	 */
	private float lon;

	public void setEquipmentPosition(EquipmentEntity equipmentPosition) {
		this.equipmentPosition = equipmentPosition;
	}

	public EquipmentEntity getEquipmentPosition() {
		return equipmentPosition;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

}
