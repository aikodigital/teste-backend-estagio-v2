package com.aiko.testebackendestagiov2.models.pk;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.models.EquipmentState;

@Embeddable
public class EquipmentStateHistoryPK implements Serializable {

    @ManyToOne  @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    
    @ManyToOne  @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    private LocalDateTime date;

    public EquipmentStateHistoryPK(){}

    public EquipmentStateHistoryPK(Equipment equipment, EquipmentState equipmentState, LocalDateTime date) {
        this.equipment = equipment;
        this.equipmentState = equipmentState;
        this.date = date;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
        result = prime * result + ((equipmentState == null) ? 0 : equipmentState.hashCode());
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
        EquipmentStateHistoryPK other = (EquipmentStateHistoryPK) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (equipment == null) {
            if (other.equipment != null)
                return false;
        } else if (!equipment.equals(other.equipment))
            return false;
        if (equipmentState == null) {
            if (other.equipmentState != null)
                return false;
        } else if (!equipmentState.equals(other.equipmentState))
            return false;
        return true;
    }
    
}
