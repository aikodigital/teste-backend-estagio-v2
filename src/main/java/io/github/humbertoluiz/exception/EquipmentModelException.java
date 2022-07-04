package io.github.humbertoluiz.exception;


public class EquipmentModelException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EquipmentModelException() {
		super( "EquipmentModel não encontrado." );
	}

}