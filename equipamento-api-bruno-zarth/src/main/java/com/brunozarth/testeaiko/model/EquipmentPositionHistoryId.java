package com.brunozarth.testeaiko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
@Table(name = "equipment_position_history", schema = "operation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPositionHistoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
