package com.brunopereira.projetoaiko.service.exceptions;

public class ModelNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ModelNotFoundException() {
		super("Model Not Found in DataBase");
	}

}
