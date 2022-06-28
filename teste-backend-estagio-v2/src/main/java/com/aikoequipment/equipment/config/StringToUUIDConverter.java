package com.aikoequipment.equipment.config;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToUUIDConverter implements Converter<String, UUID> {

	@Override
	public UUID convert(String source) {
		try {
			return UUID.fromString(source);
		}
		catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Invalid input UUID string");
		}
	}
}
