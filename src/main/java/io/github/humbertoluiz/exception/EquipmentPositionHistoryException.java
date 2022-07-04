package io.github.humbertoluiz.exception;

public class EquipmentPositionHistoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipmentPositionHistoryException( ) {
		super( "EquipmentPositionHistory não encontrado." );
	}
}
