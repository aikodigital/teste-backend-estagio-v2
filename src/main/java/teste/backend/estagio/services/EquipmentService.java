package teste.backend.estagio.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import teste.backend.estagio.entities.Equipment;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<Equipment> findAll() {
		return equipmentRepository.findAll();
	}

	public Equipment findById(UUID id) {

		Optional<Equipment> obj = equipmentRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Equipment insert(Equipment obj) {
		return equipmentRepository.save(obj);
	}

	public void delete(UUID id) {
		try {
			equipmentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Equipment update(UUID id, Equipment obj) {
		try {
			Equipment entity = equipmentRepository.getReferenceById(id);
			updateData(entity, obj);
			return equipmentRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Equipment entity, Equipment obj) {
		entity.setName(obj.getName());

	}

}
