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
import teste.backend.estagio.entities.EquipmentState;
import teste.backend.estagio.entities.EquipmentStateHistory;
import teste.backend.estagio.entities.pk.EquipmentStateHistoryPk;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentRepository;
import teste.backend.estagio.repository.EquipmentStateHistoryRepository;
import teste.backend.estagio.repository.EquipmentStateRepository;

@Service
public class EquipmentStateHistoryService {

	@Autowired
	private EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	@Autowired
	private EquipmentStateRepository equipmentStateRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<EquipmentStateHistory> findAll() {
		return equipmentStateHistoryRepository.findAll();
	}

	public EquipmentStateHistory findById(UUID id_equipment,UUID id_state) {
		Equipment equipment = equipmentRepository.findById(id_equipment).get();
		EquipmentState equipmentState = equipmentStateRepository.findById(id_state).get();
		EquipmentStateHistoryPk id = new EquipmentStateHistoryPk(equipment,equipmentState);
		Optional<EquipmentStateHistory> obj = equipmentStateHistoryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<EquipmentStateHistory> currentEquipmentState(UUID id_equipment) {
		return equipmentStateHistoryRepository.currentEquipmentState(id_equipment);
		
	}

	public EquipmentStateHistory insert(EquipmentStateHistory obj) {
		return equipmentStateHistoryRepository.save(obj);
	}

	public void delete(UUID id_equipment, UUID id_state) {
		try {
			Equipment equipment = equipmentRepository.findById(id_equipment).get();
			EquipmentState equipmentState = equipmentStateRepository.findById(id_state).get();
			EquipmentStateHistoryPk id = new EquipmentStateHistoryPk(equipment, equipmentState);
			equipmentStateHistoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EquipmentStateHistory update(UUID id_equipment, UUID id_state,
			EquipmentStateHistory obj) {
		try {
			Equipment equipment = equipmentRepository.findById(id_equipment).get();
			EquipmentState equipmentState = equipmentStateRepository.findById(id_state).get();
			EquipmentStateHistoryPk id = new EquipmentStateHistoryPk(equipment, equipmentState);
			EquipmentStateHistory entity = equipmentStateHistoryRepository.findById(id).get();
			updateData(entity, obj);
			return equipmentStateHistoryRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		}
	}

	private void updateData(EquipmentStateHistory entity, EquipmentStateHistory obj) {
		entity.setDate(obj.getDate());

	}

}
