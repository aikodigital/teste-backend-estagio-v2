package com.equipments.apirest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings {

    @EmbeddedId
    private EquipmentModelStateHourlyEarningsId id;

    private Float value;

}


