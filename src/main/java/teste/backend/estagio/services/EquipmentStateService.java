package teste.backend.estagio.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import teste.backend.estagio.entities.EquipmentState;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentStateRepository;

@Service
public class EquipmentStateService {

	@Autowired
	private EquipmentStateRepository equipmentStateRepository;

	public List<EquipmentState> findAll() {
		return equipmentStateRepository.findAll();
	}

	public EquipmentState findById(UUID id) {

		Optional<EquipmentState> obj = equipmentStateRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public EquipmentState insert(EquipmentState obj) {
		return equipmentStateRepository.save(obj);
	}

	public void delete(UUID id) {
		try {
			equipmentStateRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EquipmentState update(UUID id, EquipmentState obj) {
		try {
			EquipmentState entity = equipmentStateRepository.getReferenceById(id);
			updateData(entity, obj);
			return equipmentStateRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(EquipmentState entity, EquipmentState obj) {
		entity.setName(obj.getName());

	}

}
