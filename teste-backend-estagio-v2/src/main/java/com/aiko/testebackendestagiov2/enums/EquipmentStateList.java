package com.aiko.testebackendestagiov2.enums;


import lombok.Getter;

@Getter
public enum EquipmentStateList {
    OPERANDO("OPERANDO", "#00FF00"),
    PARADO("PARADO", "#FFFF00"),
    MANUTENCAO("MANUTENÇÃO", "#FF0000");

    private String name;
    private String color;

    EquipmentStateList(String name) {
        this.name = name;
    }

    EquipmentStateList(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
