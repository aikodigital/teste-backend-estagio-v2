package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class StateDateId implements Serializable {

    private UUID equipment;

    private LocalDateTime date;

    public StateDateId() {

    }

    public StateDateId(Equipment equipment, LocalDateTime date) {
        this.equipment = equipment.getId();
        this.date = date;
    }

    public UUID getEquipment() {
        return equipment;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
