package com.app.project.util;

import com.app.project.domain.EquipmentModel;

public class EquipmentModelCreator {

    public static EquipmentModel createEquipmentModelToBeSaved() {
        return EquipmentModel.builder()
                .name("130G")
                .build();
    }
}
