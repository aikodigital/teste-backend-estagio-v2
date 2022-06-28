package br.com.model;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Classe de persistência que representa o histórico de estados de equipamentos
 * @author Danillo Santiago
 * @since jun 2022
 */
@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistoryEntity {

	/**
	 * Mapeamento da classe com as chaves estrangeiras estado de quipamento ID e equipamento ID
	 */
	@EmbeddedId
	private EquipmentStateHistoryPK historyPK = new EquipmentStateHistoryPK();
	
	/**
	 * Relacionamento e mapeamento com a chave estrangeira de estado de equipamento
	 */
	@MapsId("equipmentStateId")
	@ManyToOne
	@JoinColumn(name = "equipmentStateId", referencedColumnName = "id")
	private EquipmentStateEntity equipmentState;

	/**
	 * Relacionamento e mapeamento com a chave estrangeira de equipamento
	 */
	@MapsId("equipmentId")
	@ManyToOne
	@JoinColumn(name = "equipmentId", referencedColumnName = "id")
	private EquipmentEntity equipment1;

	/**
	 * Atributo de data do histórico de estado do equipamento do tipo Date 
	 */
	
	private LocalDateTime date;

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public EquipmentStateEntity getEquipmentstate() {
		return equipmentState;
	}

	public void setEquipmentstate(EquipmentStateEntity equipmentstate) {
		this.equipmentState = equipmentstate;
	}

	public EquipmentEntity getEquipment1() {
		return equipment1;
	}

	public void setEquipment1(EquipmentEntity equipment1) {
		this.equipment1 = equipment1;
	}

}
