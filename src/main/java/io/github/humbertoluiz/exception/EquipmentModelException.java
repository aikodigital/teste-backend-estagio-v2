package io.github.humbertoluiz.exception;

import java.util.UUID;

public class EquipmentModelException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EquipmentModelException(String mensagem) {
	}

	public EquipmentModelException(UUID equipmentModelId ) {
		this(String.format("Não existe um cadastro de equipmentModel com código %d", equipmentModelId));
		
	}


}