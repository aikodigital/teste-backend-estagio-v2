package io.github.humbertoluiz.exception;

import java.util.UUID;

public class EquipmentStateException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EquipmentStateException() {
		super( "EquipmentState não encontrado." );
	}
	
	public EquipmentStateException(String mensagem) {
		
	}

	public EquipmentStateException(UUID equipmentStateId) {
		this(String.format("Não existe um cadastro de equipmentState com código %d", equipmentStateId));
		
	}
}