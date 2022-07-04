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

import io.github.humbertoluiz.domain.entity.Equipment;
import io.github.humbertoluiz.domain.entity.EquipmentState;
import io.github.humbertoluiz.domain.entity.EquipmentStateHistory;
import io.github.humbertoluiz.domain.repository.EquipmentRepository;
import io.github.humbertoluiz.domain.repository.EquipmentStateHistoryRepository;
import io.github.humbertoluiz.domain.repository.EquipmentStateRepository;
import io.github.humbertoluiz.dto.EquipmentStateHistoryDTO;
import io.github.humbertoluiz.exception.EquipmentStateHistoryException;
import io.github.humbertoluiz.exception.RegraNegocioException;
import io.github.humbertoluiz.service.EquipmentStateHistoryService;

@Service
public class EquipmentStateHistoryServiceImpl implements EquipmentStateHistoryService {
	
	@Autowired
	private EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private EquipmentStateRepository equipmentStateRepository;
	
    @Override
    @Transactional
    public EquipmentStateHistory save( EquipmentStateHistoryDTO equipmentStateHistoryDTO ) {
    /*-----------------------------------------------------------------------------------------*/    	
    	UUID equipmentId = equipmentStateHistoryDTO.getEquipmentId();
        Equipment equipment = equipmentRepository
                .findById(equipmentId)
                .orElseThrow( () -> new RegraNegocioException("Código de Equiment inválido."));        
    /*-----------------------------------------------------------------------------------------*/
        UUID equipmentStateId = equipmentStateHistoryDTO.getEquipmentStateId();
        EquipmentState equipmentState = equipmentStateRepository
                .findById(equipmentStateId)
                .orElseThrow( () -> new RegraNegocioException("Código de EquimentState inválido."));        
    /*-----------------------------------------------------------------------------------------*/        
        EquipmentStateHistory equipmentStateHistory = new EquipmentStateHistory();
        equipmentStateHistory.setDate(equipmentStateHistoryDTO.getDate());
        equipmentStateHistory.setEquipment(equipment);
        equipmentStateHistory.setEquipmentState(equipmentState);
        equipmentStateHistoryRepository.save(equipmentStateHistory);
        return (equipmentStateHistory);         
    }

	@Override
	public Optional<EquipmentStateHistory> getById(UUID equipmentStateHistoryId) {
		// Buscar Cliente por ID.
		Optional<EquipmentStateHistory> equipmentStateHistory = Optional.ofNullable(equipmentStateHistoryRepository.findById(equipmentStateHistoryId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "equipmentStateHistory não encontrado")));
		return Optional.ofNullable(equipmentStateHistory.get());
	}
    
	public List<EquipmentStateHistory> getByFilter(EquipmentStateHistory filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<EquipmentStateHistory> example = Example.of(filter, matcher);
		return equipmentStateHistoryRepository.findAll(example);
	}

	@Override
	@Transactional
	public Optional<EquipmentStateHistory> update(UUID equipmentStateHistoryId, EquipmentStateHistory equipmentStateHistory) {
		Optional<EquipmentStateHistory> equipmentStateHistoryData = Optional.ofNullable(
				equipmentStateHistoryRepository.findById(equipmentStateHistoryId)
			.orElseThrow(() -> new EquipmentStateHistoryException()));
		EquipmentStateHistory equipmentStateHistoryNew = equipmentStateHistoryData.get();
		equipmentStateHistoryNew.setDate(equipmentStateHistory.getDate());
		equipmentStateHistoryRepository.save(equipmentStateHistoryNew);
		return Optional.ofNullable(equipmentStateHistoryNew);
	}

	@Override
	@Transactional
	public void delete(UUID equipmentStateHistoryId) {
		// Deletar Cliente por ID.
		equipmentStateHistoryRepository
		.findById(equipmentStateHistoryId)
		.map( equipmentStateHistory -> {
			equipmentStateHistoryRepository.delete(equipmentStateHistory);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentStateHistory não encontrado"));
	}
}
