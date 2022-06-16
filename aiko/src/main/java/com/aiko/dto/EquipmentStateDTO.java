package com.aiko.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class EquipmentStateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private UUID equipmentId;
	private UUID equipmentStateId;
	private String name;
	private String color;
	
}
