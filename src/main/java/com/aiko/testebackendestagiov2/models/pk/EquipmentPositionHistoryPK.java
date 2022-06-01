package com.aiko.testebackendestagiov2.models.pk;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.aiko.testebackendestagiov2.models.Equipment;

@Embeddable
public class EquipmentPositionHistoryPK implements Serializable {
    
    @ManyToOne
    private Equipment equipment;

    private LocalDateTime date;

    public EquipmentPositionHistoryPK(){}

    public EquipmentPositionHistoryPK(Equipment equipment, LocalDateTime date) {
        this.equipment = equipment;
        this.date = date;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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
        EquipmentPositionHistoryPK other = (EquipmentPositionHistoryPK) obj;
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
        return true;
    }

    

}
