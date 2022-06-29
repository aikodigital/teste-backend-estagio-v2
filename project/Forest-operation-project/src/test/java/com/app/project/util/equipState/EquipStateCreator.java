package com.app.project.util.equipState;

import com.app.project.domain.EquipmentState;

import java.util.UUID;

public class EquipStateCreator {

    public static EquipmentState createEquipmentStateValid() {
        return EquipmentState.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .name("Stopped")
                .color("Blue")
                .build();
    }

    public static EquipmentState createEquipmentStateToBeSaved() {
        return EquipmentState.builder()
                .name("Stopped")
                .color("Blue")
                .build();
    }
}
