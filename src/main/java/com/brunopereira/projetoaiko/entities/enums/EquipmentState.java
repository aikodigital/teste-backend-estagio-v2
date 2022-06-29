package com.brunopereira.projetoaiko.entities.enums;

public enum EquipmentState {
	OPERANDO("LARANJA"), 
	PARADO("VERMELHO"), 
	MANUTENCAO("AZUL");

	private String color;

	private EquipmentState(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public static EquipmentState value(String color) {
		for (EquipmentState value : EquipmentState.values()) {
			if (value.getColor() == color) {
				return value;
			}

		}
		throw new IllegalArgumentException("Invalid EquipmentState color");
	}

}
