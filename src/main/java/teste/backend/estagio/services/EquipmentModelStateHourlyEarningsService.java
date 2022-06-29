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
import teste.backend.estagio.entities.EquipmentModelStateHourlyEarnings;
import teste.backend.estagio.entities.EquipmentState;
import teste.backend.estagio.entities.pk.EquipmentModelStateHourlyEarningsPk;
import teste.backend.estagio.exceptions.DatabaseException;
import teste.backend.estagio.exceptions.ResourceNotFoundException;
import teste.backend.estagio.repository.EquipmentModelRepository;
import teste.backend.estagio.repository.EquipmentModelStateHourlyEarningsRepository;
import teste.backend.estagio.repository.EquipmentStateRepository;

@Service
public class EquipmentModelStateHourlyEarningsService {

	@Autowired
	private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;
	@Autowired
	private EquipmentModelRepository eModelRepository;
	@Autowired
	private EquipmentStateRepository eStateRepository;

	public List<EquipmentModelStateHourlyEarnings> findAll() {
		return equipmentModelStateHourlyEarningsRepository.findAll();
	}

	public EquipmentModelStateHourlyEarnings findById(UUID id_model, UUID id_state) {
		EquipmentModel eModel = eModelRepository.findById(id_model).get();
		EquipmentState eState = eStateRepository.findById(id_state).get();
		EquipmentModelStateHourlyEarningsPk id = new EquipmentModelStateHourlyEarningsPk(eModel, eState);
		Optional<EquipmentModelStateHourlyEarnings> obj = equipmentModelStateHourlyEarningsRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public EquipmentModelStateHourlyEarnings insert(EquipmentModelStateHourlyEarnings obj) {
		return equipmentModelStateHourlyEarningsRepository.save(obj);
	}

	public void delete(UUID id_model, UUID id_state) {
		try {
			EquipmentModel eModel = eModelRepository.findById(id_model).get();
			EquipmentState eState = eStateRepository.findById(id_state).get();
			EquipmentModelStateHourlyEarningsPk id = new EquipmentModelStateHourlyEarningsPk(eModel, eState);
			equipmentModelStateHourlyEarningsRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EquipmentModelStateHourlyEarnings update(UUID id_model, UUID id_state,
			EquipmentModelStateHourlyEarnings obj) {
		try {
			EquipmentModel eModel = eModelRepository.findById(id_model).get();
			EquipmentState eState = eStateRepository.findById(id_state).get();
			EquipmentModelStateHourlyEarningsPk id = new EquipmentModelStateHourlyEarningsPk(eModel, eState);
			EquipmentModelStateHourlyEarnings entity = equipmentModelStateHourlyEarningsRepository.findById(id).get();
			updateData(entity, obj);
			return equipmentModelStateHourlyEarningsRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		}
	}

	private void updateData(EquipmentModelStateHourlyEarnings entity, EquipmentModelStateHourlyEarnings obj) {
		entity.setValue(obj.getValue());

	}

}
