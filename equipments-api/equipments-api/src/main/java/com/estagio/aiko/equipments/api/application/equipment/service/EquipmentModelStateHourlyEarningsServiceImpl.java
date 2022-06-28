package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModelStateHourlyEarnings;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentState;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentModelStateHourlyEarningsService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentModelRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentModelStateHourlyEarningsRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateRepository;

@Service
public class EquipmentModelStateHourlyEarningsServiceImpl implements EquipmentModelStateHourlyEarningsService {

	private final EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;
	private final EquipmentModelRepository equipmentModelRepository;
	private final EquipmentStateRepository equipmentStateRepository;

	public EquipmentModelStateHourlyEarningsServiceImpl(
			EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
			EquipmentModelRepository equipmentModelRepository, EquipmentStateRepository equipmentStateRepository) {
		this.equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
		this.equipmentModelRepository = equipmentModelRepository;
		this.equipmentStateRepository = equipmentStateRepository;
	}

	@Override
	public EquipmentModelStateHourlyEarnings create(EquipmentModelStateHourlyEarnings object) {
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment model"));
		EquipmentState state = equipmentStateRepository.findById(object.getState().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment state"));

		object.setModel(model);
		object.setState(state);

		return equipmentModelStateHourlyEarningsRepository.save(object);
	}

	@Override
	public EquipmentModelStateHourlyEarnings update(UUID id, EquipmentModelStateHourlyEarnings object) {
		EquipmentModelStateHourlyEarnings savedEquipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsRepository
				.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment model"));
		EquipmentState state = equipmentStateRepository.findById(object.getState().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment state"));

		object.setModel(model);
		object.setState(state);
		BeanUtils.copyProperties(object, savedEquipmentModelStateHourlyEarnings, "id");

		return equipmentModelStateHourlyEarningsRepository.save(savedEquipmentModelStateHourlyEarnings);
	}

	@Override
	public List<EquipmentModelStateHourlyEarnings> findAll() {
		return equipmentModelStateHourlyEarningsRepository.findAll();
	}

	@Override
	public EquipmentModelStateHourlyEarnings findById(UUID id) {
		return equipmentModelStateHourlyEarningsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void delete(UUID id) {
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsRepository
				.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		equipmentModelStateHourlyEarningsRepository.delete(equipmentModelStateHourlyEarnings);
	}

}
