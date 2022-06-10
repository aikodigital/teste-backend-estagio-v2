package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;
import java.util.UUID;

public class ModelStateId implements Serializable {
    private UUID equipmentModel;

    private UUID equipmentState;

    public ModelStateId() {

    }

    public ModelStateId(EquipmentModel equipmentModel, EquipmentState equipmentState) {
        this.equipmentModel = equipmentModel.getId();
        this.equipmentState = equipmentState.getId();
    }

    public UUID getEquipmentModel() {
        return equipmentModel;
    }

    public UUID getEquipmentState() {
        return equipmentState;
    }
}
