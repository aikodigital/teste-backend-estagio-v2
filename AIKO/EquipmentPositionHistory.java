package com.suellenoliveiraprog.aikoprova.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/* O histórico de posições dos equipamentos. */

@Entity
public class EquipmentPositionHistory {
    
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Integer equipment_id; //Chave estrangeira, utilizada para referenciar de qual equipamento é essa posição.
    private Date date; //Data em que a posição foi registrada.
    private Double lat; //Latitude em WGS84.
    private Double lon; //Longitude em WGS84.

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
    
}
