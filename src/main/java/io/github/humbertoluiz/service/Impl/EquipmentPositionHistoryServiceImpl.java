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
import io.github.humbertoluiz.domain.entity.EquipmentPositionHistory;
import io.github.humbertoluiz.domain.repository.EquipmentPositionHistoryRepository;
import io.github.humbertoluiz.domain.repository.EquipmentRepository;
import io.github.humbertoluiz.dto.EquipmentPositionHistoryDTO;
import io.github.humbertoluiz.exception.EquipmentPositionHistoryException;
import io.github.humbertoluiz.exception.RegraNegocioException;
import io.github.humbertoluiz.service.EquipmentPositionHystoryService;

@Service
public class EquipmentPositionHistoryServiceImpl implements EquipmentPositionHystoryService {

	@Autowired
	private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;
	
    @Override
    @Transactional
    public EquipmentPositionHistory save( EquipmentPositionHistoryDTO equipmentPositionHistoryDTO ) {
        UUID equipmentId = equipmentPositionHistoryDTO.getEquipmentId();
        Equipment equipment= equipmentRepository
                .findById(equipmentId)
                .orElseThrow( () ->new RegraNegocioException("Código de Equiment inválido."));
        EquipmentPositionHistory equipmentPositionHistory = new EquipmentPositionHistory();
        equipmentPositionHistory.setDate(equipmentPositionHistoryDTO.getDate());
        equipmentPositionHistory.setLat(equipmentPositionHistoryDTO.getLat());
        equipmentPositionHistory.setLon(equipmentPositionHistoryDTO.getLon());
        equipmentPositionHistory.setEquipment(equipment);
        equipmentPositionHistoryRepository.save(equipmentPositionHistory);
        return (equipmentPositionHistory);         
    }

	@Override
	public Optional<EquipmentPositionHistory> getById(UUID equipmentPositionHistoryId) {
		// Buscar Cliente por ID.
		Optional<EquipmentPositionHistory> equipmentPositionHistory = Optional.ofNullable(equipmentPositionHistoryRepository.findById(equipmentPositionHistoryId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentPositionHistory não encontrado")));
		return Optional.ofNullable(equipmentPositionHistory.get());
	}
    
	public List<EquipmentPositionHistory> getByFilter(EquipmentPositionHistory filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<EquipmentPositionHistory> example = Example.of(filter, matcher);
		return equipmentPositionHistoryRepository.findAll(example);
	}

	@Override
	@Transactional
	public void update(UUID equipmentPositionHistoryId) {
		equipmentPositionHistoryRepository.findById(equipmentPositionHistoryId)
		.map( equipmentPositionHistory -> {
			return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
		}).orElseThrow( () -> new EquipmentPositionHistoryException());
		
	}

	@Override
	public void delete(UUID equipmentPositionHistoryId) {
		// Deletar Cliente por ID.
		equipmentPositionHistoryRepository
		.findById(equipmentPositionHistoryId)
		.map( equipmentPositionHistory -> {
			equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EquipmentPositionHistory não encontrado"));
	}
}
