package com.app.project.util.equipModel;

import com.app.project.domain.EquipmentModel;

public class EquipmentModelCreator {

    public static EquipmentModel createEquipmentModelToBeSaved() {
        return EquipmentModel.builder()
                .name("130G")
                .build();
    }

    public static EquipmentModel createEquipmentModelValid() {
        return EquipmentModel.builder()
                .id(1L)
                .name("130G")
                .build();
    }
}
