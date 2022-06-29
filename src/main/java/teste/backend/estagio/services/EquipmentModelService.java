package teste.backend.estagio.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import teste.backend.estagio.entities.EquipmentModel;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentModelRepository;

@Service
public class EquipmentModelService {

	@Autowired
	private EquipmentModelRepository equipmentModelRepository;

	public List<EquipmentModel> findAll() {
		return equipmentModelRepository.findAll();
	}

	public EquipmentModel findById(UUID id) {

		Optional<EquipmentModel> obj = equipmentModelRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public EquipmentModel insert(EquipmentModel obj) {
		return equipmentModelRepository.save(obj);
	}

	public void delete(UUID id) {
		try {
			equipmentModelRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EquipmentModel update(UUID id, EquipmentModel obj) {
		try {
			EquipmentModel entity = equipmentModelRepository.getReferenceById(id);
			updateData(entity, obj);
			return equipmentModelRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(EquipmentModel entity, EquipmentModel obj) {
		entity.setName(obj.getName());

	}

}
