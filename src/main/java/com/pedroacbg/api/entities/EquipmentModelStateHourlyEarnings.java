package com.pedroacbg.api.entities;

import com.pedroacbg.api.pk.EquipmentModelStateHourlyEarningsPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModelStateHourlyEarnings implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK();

    @NotNull
    private Float value;
}
