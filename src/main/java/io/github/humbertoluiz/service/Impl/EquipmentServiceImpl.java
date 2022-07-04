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
import io.github.humbertoluiz.domain.entity.EquipmentModel;
import io.github.humbertoluiz.domain.repository.EquipmentModelRepository;
import io.github.humbertoluiz.domain.repository.EquipmentRepository;
import io.github.humbertoluiz.dto.EquipmentDTO;
import io.github.humbertoluiz.exception.EquipmentException;
import io.github.humbertoluiz.exception.RegraNegocioException;
import io.github.humbertoluiz.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private EquipmentModelRepository equipmentModelRepository;
	
    @Override
    @Transactional
    public Equipment save( EquipmentDTO equipmentDTO ) {
        UUID equipmentModelId = equipmentDTO.getEquipmentModelId();
        EquipmentModel equipmentModel = equipmentModelRepository
                .findById(equipmentModelId)
                .orElseThrow( () -> new RegraNegocioException("Código de EquimentModel inválido."));
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDTO.getName());
        equipment.setEquipmentModel(equipmentModel);
        equipmentRepository.save(equipment);
        return (equipment);         
    }

	@Override
	public Optional<Equipment> getById(UUID equipmentId) {
		// Buscar Cliente por ID.
		Optional<Equipment> equipment = Optional.ofNullable(equipmentRepository.findById(equipmentId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado")));
		return Optional.ofNullable(equipment.get());
	}
    
	@Override
	public List<Equipment> getByFilter(Equipment filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Equipment> example = Example.of(filter, matcher);
		return equipmentRepository.findAll(example);
	}
	
	@Override
	@Transactional
	public Optional<Equipment> update(UUID equipmentId, Equipment equipment) {
		Optional<Equipment> equipmentData = Optional.ofNullable(
			equipmentRepository.findById(equipmentId)
			.orElseThrow(() -> new EquipmentException()));
		Equipment equipmentNew = equipmentData.get();
		equipmentNew.setName(equipment.getName());
		equipmentRepository.save(equipmentNew);
		return Optional.ofNullable(equipmentNew);
	}
	
	@Override
	@Transactional
	public void delete(UUID equipmentId) {
		// Deletar Cliente por ID.
		equipmentRepository
		.findById(equipmentId)
		.map( equipment -> {
			equipmentRepository.delete(equipment);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado"));
	}

}
