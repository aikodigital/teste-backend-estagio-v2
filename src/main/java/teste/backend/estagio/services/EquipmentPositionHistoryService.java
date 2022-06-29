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
import teste.backend.estagio.entities.EquipmentPositionHistory;
import teste.backend.estagio.entities.pk.EquipmentPositionHistoryPk;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentPositionHistoryRepository;
import teste.backend.estagio.repository.EquipmentRepository;

@Service
public class EquipmentPositionHistoryService {

	@Autowired
	private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<EquipmentPositionHistory> findAll() {
		return equipmentPositionHistoryRepository.findAll();
	}

	public EquipmentPositionHistory findById(UUID id_equipment) {
		Equipment equipment = equipmentRepository.findById(id_equipment).get();
		EquipmentPositionHistoryPk id = new EquipmentPositionHistoryPk(equipment);
		Optional<EquipmentPositionHistory> obj = equipmentPositionHistoryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<EquipmentPositionHistory> currentEquipmentPosition(UUID id_equipment) {
		return equipmentPositionHistoryRepository.currentEquipmentPosition(id_equipment);
		
	}

	public EquipmentPositionHistory insert(EquipmentPositionHistory obj) {
		return equipmentPositionHistoryRepository.save(obj);
	}

	public void delete(UUID id_equipment) {
		try {
			Equipment equipment = equipmentRepository.findById(id_equipment).get();
			EquipmentPositionHistoryPk id = new EquipmentPositionHistoryPk(equipment);
			equipmentPositionHistoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EquipmentPositionHistory update(UUID id_equipment,
			EquipmentPositionHistory obj) {
		try {
			Equipment equipment = equipmentRepository.findById(id_equipment).get();
			EquipmentPositionHistoryPk id = new EquipmentPositionHistoryPk(equipment);
			EquipmentPositionHistory entity = equipmentPositionHistoryRepository.findById(id).get();
			updateData(entity, obj);
			return equipmentPositionHistoryRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		}
	}

	private void updateData(EquipmentPositionHistory entity, EquipmentPositionHistory obj) {
		entity.setDate(obj.getDate());

	}

}
