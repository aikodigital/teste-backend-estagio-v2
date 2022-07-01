package com.br.raf.equipments.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipmentModelStateHourlyEarnings {

    @Column(name = "equipment_model_id")
    private UUID equipmentModelId;

    @Column(name = "equipment_state_id")
    private UUID equipmentStateId;
    @Id
    private Integer value;
}
