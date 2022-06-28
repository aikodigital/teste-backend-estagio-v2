package io.github.humbertoluiz.exception;

public class EquipmentModelStateHourlyEarningsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipmentModelStateHourlyEarningsException() {
		super( "EquipmentModelStateHourlyEarnings não encontrado." );
	}
}
