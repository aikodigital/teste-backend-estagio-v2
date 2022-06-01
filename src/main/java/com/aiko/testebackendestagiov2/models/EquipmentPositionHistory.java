package com.aiko.testebackendestagiov2.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aiko.testebackendestagiov2.models.pk.EquipmentPositionHistoryPK;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
public  class EquipmentPositionHistory implements Serializable {

    @EmbeddedId
    EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK();

    private Float lat;
    private Float lon;

    /* public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    } */
    public Float getLat() {
        return lat;
    }
    public void setLat(Float lat) {
        this.lat = lat;
    }
    public Float getLon() {
        return lon;
    }
    public void setLon(Float lon) {
        this.lon = lon;
    }
    public Equipment getEquipment() {
        return id.getEquipment();
    }
    public void setEquipment(Equipment equipment) {
        id.setEquipment(equipment);
    }
    public LocalDateTime getDate(){
        return id.getDate();
    }
    public void setDate(LocalDateTime date){
        id.setDate(date);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lat == null) ? 0 : lat.hashCode());
        result = prime * result + ((lon == null) ? 0 : lon.hashCode());
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
        EquipmentPositionHistory other = (EquipmentPositionHistory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lat == null) {
            if (other.lat != null)
                return false;
        } else if (!lat.equals(other.lat))
            return false;
        if (lon == null) {
            if (other.lon != null)
                return false;
        } else if (!lon.equals(other.lon))
            return false;
        return true;
    }

    

}