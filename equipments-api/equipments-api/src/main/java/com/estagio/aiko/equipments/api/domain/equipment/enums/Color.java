package com.estagio.aiko.equipments.api.domain.equipment.enums;

public enum Color {

	GREEN("#2ecc71"), ORANGE("#f1c40f"), RED("#e74c3c");
	
	private final String hex;

	Color(String hex) {
		this.hex = hex;
	}

	public String getHex() {
		return hex;
	}
	
}
