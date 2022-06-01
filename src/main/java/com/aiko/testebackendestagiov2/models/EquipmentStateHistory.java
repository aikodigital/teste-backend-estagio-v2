package com.aiko.testebackendestagiov2.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aiko.testebackendestagiov2.models.pk.EquipmentStateHistoryPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory implements Serializable {

    @EmbeddedId @JsonIgnore
    private EquipmentStateHistoryPK id = new EquipmentStateHistoryPK();

    public EquipmentStateHistory() {
    }

    public Equipment getEquipment(){
        return id.getEquipment();
    }

    public void setEquipment(Equipment equipment){
        id.setEquipment(equipment);
    }

    public EquipmentState getEquipmentState(){
        return id.getEquipmentState();
    }

    public void setEquipmentState(EquipmentState equipmentState){
        id.setEquipmentState(equipmentState);
    }

    public LocalDateTime getDate() {
        return id.getDate();
    }

    public void setDate(LocalDateTime date) {
        id.setDate(date);
    }

    public EquipmentStateHistoryPK getId(){
        return id;
    }

}