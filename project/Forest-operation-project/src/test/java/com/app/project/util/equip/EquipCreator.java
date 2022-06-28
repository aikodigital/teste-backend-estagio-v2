package com.app.project.util.equip;

import com.app.project.domain.Equipment;
import com.app.project.util.equipModel.EquipmentModelCreator;

import java.util.UUID;

public class EquipCreator {

    public static Equipment createEquipmentToBeSaved() {
        return Equipment.builder()
                .name("130G")
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .build();
    }

    public static Equipment createEquipmentValid() {
        return Equipment.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .name("130G")
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .build();
    }
}
