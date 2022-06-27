package com.brunozarth.testeaiko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStateHistory {
    @EmbeddedId
    EquipmentStateHistoryId id;

    @Column(name = "date", nullable = false)
    Timestamp date;

    public EquipmentStateHistoryId getId() {
        return id;
    }

    public void setId(EquipmentStateHistoryId id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
