package com.app.project.util.equipState;

import com.app.project.domain.EquipmentState;

public class EquipStateCreator {

    public static EquipmentState createEquipmentStateValid() {
        return EquipmentState.builder()
                .id(1L)
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
