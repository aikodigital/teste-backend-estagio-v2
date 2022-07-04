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
import io.github.humbertoluiz.domain.entity.EquipmentModel;
import io.github.humbertoluiz.domain.entity.EquipmentModelStateHourlyEarnings;
import io.github.humbertoluiz.domain.entity.EquipmentState;
import io.github.humbertoluiz.domain.repository.EquipmentModelRepository;
import io.github.humbertoluiz.domain.repository.EquipmentModelStateHourlyEarningsRepository;
import io.github.humbertoluiz.domain.repository.EquipmentStateRepository;
import io.github.humbertoluiz.dto.EquipmentModelStateHourlyEarningsDTO;
import io.github.humbertoluiz.exception.EquipmentModelStateHourlyEarningsException;
import io.github.humbertoluiz.exception.RegraNegocioException;
import io.github.humbertoluiz.service.EquipmentModelStateHourlyEarningsService;

@Service
public class EquipmentModelStateHourlyEarningsServiceImpl implements EquipmentModelStateHourlyEarningsService {

	@Autowired
	private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;
	@Autowired
	private EquipmentModelRepository equipmentModelRepository;
	@Autowired
	private EquipmentStateRepository equipmentStateRepository;

	@Override
	@Transactional
	public EquipmentModelStateHourlyEarnings save(
			EquipmentModelStateHourlyEarningsDTO equipmentModelStateHourlyEarningsDTO) {
		/*-----------------------------------------------------------------------------------------*/
		UUID equipmentModelId = equipmentModelStateHourlyEarningsDTO.getEquipmentModelId();
		EquipmentModel equipmentModel = equipmentModelRepository.findById(equipmentModelId)
				.orElseThrow(() -> new RegraNegocioException("Código de EquimentModel inválido."));
		/*-----------------------------------------------------------------------------------------*/
		UUID equipmentStateId = equipmentModelStateHourlyEarningsDTO.getEquipmentStateId();
		EquipmentState equipmentState = equipmentStateRepository.findById(equipmentStateId)
				.orElseThrow(() -> new RegraNegocioException("Código de EquimentState inválido."));
		/*-----------------------------------------------------------------------------------------*/
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = new EquipmentModelStateHourlyEarnings();
		equipmentModelStateHourlyEarnings.setValue(equipmentModelStateHourlyEarningsDTO.getValue());
		equipmentModelStateHourlyEarnings.setEquipmentModel(equipmentModel);
		equipmentModelStateHourlyEarnings.setEquipmentState(equipmentState);
		equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
		return (equipmentModelStateHourlyEarnings);
	}

	@Override
	public Optional<EquipmentModelStateHourlyEarnings> getById(UUID equipmentModelStateHourlyEarningsId) {
		// Buscar Cliente por ID.
		Optional<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings = Optional
				.ofNullable(equipmentModelStateHourlyEarningsRepository.findById(equipmentModelStateHourlyEarningsId)
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
								"EquipmentModelStateHourlyEarnings não encontrado")));
		return Optional.ofNullable(equipmentModelStateHourlyEarnings.get());
	}

	public List<EquipmentModelStateHourlyEarnings> getByFilter(EquipmentModelStateHourlyEarnings filter) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<EquipmentModelStateHourlyEarnings> example = Example.of(filter, matcher);
		return equipmentModelStateHourlyEarningsRepository.findAll(example);
	}

	@Override
	@Transactional
	public Optional<EquipmentModelStateHourlyEarnings> update(UUID equipmentModelStateHourlyEarningsId, EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
		Optional<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarningsData = Optional.ofNullable(
				equipmentModelStateHourlyEarningsRepository.findById(equipmentModelStateHourlyEarningsId)
			.orElseThrow(() -> new EquipmentModelStateHourlyEarningsException()));
		EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarningsNew = equipmentModelStateHourlyEarningsData.get();
		equipmentModelStateHourlyEarningsNew.setValue(equipmentModelStateHourlyEarnings.getValue());
		equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarningsNew);
		return Optional.ofNullable(equipmentModelStateHourlyEarningsNew);
	}

	@Override
	@Transactional
	public void delete(UUID equipmentModelStateHourlyEarningsId) {
		// Deletar Cliente por ID.
		equipmentModelStateHourlyEarningsRepository.findById(equipmentModelStateHourlyEarningsId)
				.map(equipmentModelStateHourlyEarnings -> {
					equipmentModelStateHourlyEarningsRepository.delete(equipmentModelStateHourlyEarnings);
					return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment não encontrado"));
	}
}
