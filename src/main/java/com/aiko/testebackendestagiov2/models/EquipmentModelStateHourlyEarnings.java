package com.aiko.testebackendestagiov2.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aiko.testebackendestagiov2.models.pk.EquipmentModelStateHourlyEarningsPK;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings implements Serializable {
    
    @EmbeddedId
    private EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK();

    private Float value;

    public EquipmentModelStateHourlyEarnings(){}

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public EquipmentModel getEquipmentModel(){
        return id.getEquipmentModel();
    }

    public void setEquipmentModel(EquipmentModel equipmentModel){
        id.setEquipmentModel(equipmentModel);
    }

    public EquipmentState getEquipmentState(){
        return id.getEquipmentState();
    }

    public void setEquipmentState(EquipmentState equipmentState){
        id.setEquipmentState(equipmentState);
    }

}
