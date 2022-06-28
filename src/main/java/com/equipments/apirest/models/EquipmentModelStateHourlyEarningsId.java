package com.equipments.apirest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EquipmentModelStateHourlyEarningsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_model_id", foreignKey = @ForeignKey(name = "fk_equipment_model"))
    @MapsId("equipment_model_id")
    private EquipmentModel equipmentModel;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id", foreignKey = @ForeignKey(name = "fk_equipment_state"))
    @MapsId("equipment_state_id")
    private EquipmentState equipmentState;

    public EquipmentModelStateHourlyEarningsId(UUID modelId, UUID stateId) {
        this.equipmentModel = new EquipmentModel();
        this.equipmentState = new EquipmentState();

        this.equipmentModel.setId(modelId);
        this.equipmentState.setId(stateId);
    }

}
