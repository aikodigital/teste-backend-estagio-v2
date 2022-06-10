package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
@IdClass(PositionDateId.class)
public class EquipmentPositionHistory {

    @Id
    @ManyToOne(optional = false, targetEntity = Equipment.class)
    @JoinColumn(nullable = false, name = "equipment_id", foreignKey = @ForeignKey(name = "fk_equipment"))
    private Equipment equipment;

    @Id
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "lon", nullable = false)
    private Double lon;

    public LocalDateTime getDate() {
        return this.date;
    }

    public Double getLat() {
        return this.lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

}
