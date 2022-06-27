package com.brunozarth.testeaiko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModelStateHourlyEarningsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_model_id", nullable = false)
    private EquipmentModel equipmentModel;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id", nullable = false)
    private EquipmentState equipmentState;

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }
}
