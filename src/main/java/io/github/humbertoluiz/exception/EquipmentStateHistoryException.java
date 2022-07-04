package io.github.humbertoluiz.exception;

public class EquipmentStateHistoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipmentStateHistoryException() {
		super( "EquipmentStateHistory não encontrado." );
	}
}
