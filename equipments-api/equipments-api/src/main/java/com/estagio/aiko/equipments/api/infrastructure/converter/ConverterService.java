package com.estagio.aiko.equipments.api.infrastructure.converter;

import java.util.List;

public interface ConverterService {

	<T> T convert(Object data, Class<T> type);

	<S, T> List<T> convert(List<S> source, Class<T> targetClass);
	
}
