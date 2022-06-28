package com.app.project.util.equip;

import com.app.project.domain.Equipment;
import com.app.project.util.equipModel.EquipModelCreator;

import java.util.UUID;

public class EquipCreator {

    public static Equipment createEquipmentValid() {
        return Equipment.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .name("130G")
                .model(EquipModelCreator.createEquipmentModelValid())
                .build();
    }
}
