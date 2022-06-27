package com.brunozarth.testeaiko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModelStateHourlyEarnings {
    @EmbeddedId
    EquipmentModelStateHourlyEarningsId id;

    @Column(name = "value", nullable = false)
    private float value;

    public EquipmentModelStateHourlyEarningsId getId() {
        return id;
    }

    public void setId(EquipmentModelStateHourlyEarningsId id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
