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
    
	public List<Equipment> getByFilter(Equipment filter) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Equipment> example = Example.of(filter, matcher);
		return equipmentRepository.findAll(example);
	}

	@Override
	public void update(UUID equipmentId, Equipment equipment) {
		// Buscar Cliente por ID, caso exista:
		equipmentRepository.findById(equipmentId)
		.map(equipmentExistente -> {
			equipment.setId(equipmentExistente.getId());			
			equipmentRepository.save(equipmentExistente);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado"));
	}
	
	@Override
	public void delete(UUID equipmentId) {
		// Deletar Cliente por ID.
		equipmentRepository
		.findById(equipmentId)
		.map( equipment -> {
			equipmentRepository.deleteById(equipmentId);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado"));
	}

}
