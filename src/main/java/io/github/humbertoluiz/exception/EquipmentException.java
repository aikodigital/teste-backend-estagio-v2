package io.github.humbertoluiz.exception;

public class EquipmentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EquipmentException( ) {
		super( "Equipment não encontrado." );
	}
}