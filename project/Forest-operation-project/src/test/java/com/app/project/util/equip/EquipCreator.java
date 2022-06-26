package com.app.project.util.equip;

import com.app.project.domain.Equipment;
import com.app.project.util.equipModel.EquipmentModelCreator;

public class EquipCreator {

    public static Equipment createEquipmentToBeSaved() {
        return Equipment.builder()
                .name("130G")
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .build();
    }

    public static Equipment createEquipmentValid() {
        return Equipment.builder()
                .id(1L)
                .name("130G")
                .model(EquipmentModelCreator.createEquipmentModelValid())
                .build();
    }
}
