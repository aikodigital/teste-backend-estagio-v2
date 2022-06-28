package io.github.humbertoluiz.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import io.github.humbertoluiz.domain.entity.EquipmentModel;
import io.github.humbertoluiz.domain.repository.EquipmentModelRepository;
import io.github.humbertoluiz.dto.EquipmentModelDTO;
import io.github.humbertoluiz.exception.EquipmentModelException;
import io.github.humbertoluiz.service.EquipmentModelService;

@Service
public class EquipmentModelServiceImpl implements EquipmentModelService {

	@Autowired
	private EquipmentModelRepository equipmentModelRepository;

    @Override
    @Transactional
    public EquipmentModel save( EquipmentModelDTO equipmentModelDTO ) {
    	EquipmentModel equipmentModel = new EquipmentModel();
    	equipmentModel.setName(equipmentModelDTO.getName());
    	equipmentModelRepository.save(equipmentModel);
        return equipmentModel;
    }

	@Override
	public Optional<EquipmentModel> getById(UUID equipmentModelId) {
		// Buscar Cliente por ID.
		Optional<EquipmentModel> equipmentModel = Optional.ofNullable(equipmentModelRepository.findById(equipmentModelId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentModel não encontrado")));
		return Optional.ofNullable(equipmentModel.get());
	}
	
	public EquipmentModel findOrFail(UUID equipmentModelId) {
		return equipmentModelRepository.findById(equipmentModelId)
			.orElseThrow(() -> new EquipmentModelException(equipmentModelId));
	}
	
	public List<EquipmentModel> getByFilter(EquipmentModel filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<EquipmentModel> example = Example.of(filter, matcher);
		return equipmentModelRepository.findAll(example);
	}
	
	@Override
	@Transactional
	public void update(UUID equipmentModelId) {
		equipmentModelRepository.findById(equipmentModelId)
		.map( equipmentModel -> {			
			return equipmentModelRepository.save(equipmentModel);
		}).orElseThrow( () -> new EquipmentModelException(equipmentModelId));
		
	}
	
	@Override
	public void delete(UUID equipmentModelId) {
		// Deletar Cliente por ID.
		equipmentModelRepository
		.findById(equipmentModelId)
		.map( equipmentModel -> {
			equipmentModelRepository.deleteById(equipmentModelId);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado"));
	}
}