package com.estagio.aiko.equipments.api.domain.equipment.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public ResourceNotFoundException() {
		super("Resource not found!");
	}
	
	public ResourceNotFoundException(String resourceName) {
		super(resourceName + " not found!");
		this.resourceName = resourceName;
	}
}
