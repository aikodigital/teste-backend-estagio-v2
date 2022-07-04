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
import io.github.humbertoluiz.domain.entity.EquipmentState;
import io.github.humbertoluiz.domain.repository.EquipmentStateRepository;
import io.github.humbertoluiz.dto.EquipmentStateDTO;
import io.github.humbertoluiz.exception.EquipmentStateException;
import io.github.humbertoluiz.service.EquipmentStateService;

@Service
public class EquipmentStateServiceImpl implements EquipmentStateService{

	@Autowired
	private EquipmentStateRepository equipmentStateRepository;

    @Override
    @Transactional
    public EquipmentState save( EquipmentStateDTO equipmentStateDTO ) {
    	EquipmentState equipmentState = new EquipmentState();
    	equipmentState.setName(equipmentStateDTO.getName());
    	equipmentState.setColor(equipmentStateDTO.getColor());
    	equipmentStateRepository.save(equipmentState);
        return equipmentState;
    }

	@Override
	public Optional<EquipmentState> getById(UUID equipmentStateId) {
		// Buscar Cliente por ID.
		Optional<EquipmentState> equipmentState = Optional.ofNullable(equipmentStateRepository.findById(equipmentStateId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentModel não encontrado")));
		return Optional.ofNullable(equipmentState.get());
	}
	
	public EquipmentState findOrFail(UUID equipmentStateId) {
		return equipmentStateRepository.findById(equipmentStateId)
			.orElseThrow(() -> new EquipmentStateException());
	}
	
	public List<EquipmentState> getByFilter(EquipmentState filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<EquipmentState> example = Example.of(filter, matcher);
		return equipmentStateRepository.findAll(example);
	}
	
	@Override
	@Transactional
	public Optional<EquipmentState> update(UUID equipmentStateId, EquipmentState equipmentState) {
		Optional<EquipmentState> equipmentStateData = Optional.ofNullable(
			equipmentStateRepository.findById(equipmentStateId)
			.orElseThrow(() -> new EquipmentStateException()));
		EquipmentState equipmentStateNew = equipmentStateData.get();
		equipmentStateNew.setName(equipmentState.getName());
		equipmentStateNew.setColor(equipmentState.getColor());
		equipmentStateRepository.save(equipmentStateNew);
		return Optional.ofNullable(equipmentStateNew);
	}
	
	@Override
	@Transactional
	public void delete(UUID equipmentStateId) {
		// Deletar Cliente por ID.
		equipmentStateRepository
		.findById(equipmentStateId)
		.map( equipmentState -> {
			equipmentStateRepository.delete(equipmentState);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentState não encontrado"));
	}
}
