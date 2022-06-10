package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
@IdClass(StateDateId.class)
public class EquipmentStateHistory implements Serializable {

    @Id
    @ManyToOne(optional = false, targetEntity = Equipment.class)
    @JoinColumn(nullable = false, name = "equipment_id", foreignKey = @ForeignKey(name = "fk_equipment"))
    private Equipment equipment;

    @ManyToOne(optional = false, targetEntity = EquipmentState.class)
    @JoinColumn(nullable = false, name = "equipment_state_id", foreignKey = @ForeignKey(name = "fk_equipment_state"))
    private EquipmentState equipmentState;

    @Id
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    public Equipment getEquipment() {
        return equipment;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
