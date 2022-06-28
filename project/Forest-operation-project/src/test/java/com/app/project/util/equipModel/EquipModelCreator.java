package com.app.project.util.equipModel;

import com.app.project.domain.EquipmentModel;

import java.util.UUID;

public class EquipModelCreator {

    public static EquipmentModel createEquipmentModelToBeSaved() {
        return EquipmentModel.builder()
                .name("130G")
                .build();
    }

    public static EquipmentModel createEquipmentModelValid() {
        return EquipmentModel.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .name("130G")
                .build();
    }
}
