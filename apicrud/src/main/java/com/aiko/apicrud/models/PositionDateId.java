package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class PositionDateId implements Serializable {
    private UUID equipment;

    private LocalDateTime date;

    public PositionDateId() {

    }

    public PositionDateId(Equipment equipment, LocalDateTime date) {
        this.equipment = equipment.getId();
        this.date = date;
    }

    public UUID getEquipment() {
        return equipment;
    }

    public void setEquipmentId(UUID equipmentId) {
        this.equipment = equipmentId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
