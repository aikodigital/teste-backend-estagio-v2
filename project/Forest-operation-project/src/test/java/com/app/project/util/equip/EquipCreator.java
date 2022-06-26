package com.app.project.util.equip;

import com.app.project.domain.Equipment;
import com.app.project.util.equipModel.EquipmentModelCreator;

public class EquipCreator {

    public static Equipment createEquipmentModelToBeSaved() {
        return Equipment.builder()
                .name("130G")
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .build();
    }

    public static Equipment createEquipmentModelValid() {
        return Equipment.builder()
                .id(1L)
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .name("130G")
                .build();
    }
}
