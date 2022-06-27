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
@Table(name = "equipment_position_history", schema = "operation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPositionHistory {
    @EmbeddedId
    EquipmentPositionHistoryId id;

    @Column(name = "lat", nullable = false)
    float lat;

    @Column(name = "lon", nullable = false)
    float lon;

    public EquipmentPositionHistoryId getId() {
        return id;
    }

    public void setId(EquipmentPositionHistoryId id) {
        this.id = id;
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
