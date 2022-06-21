package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.HourlyEarnings;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.HourlyEarningsPK;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.*;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.HourlyEarningsRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IHourlyEarningsService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HourlyEarningsService implements IHourlyEarningsService {

    @Autowired
    private HourlyEarningsRepository earningsRepository;

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    @Override
    @Transactional(readOnly = true)
    public List<HourlyEarningsDTO> findAll(UUID stateId) {
        if (!equipmentStateRepository.existsById(stateId)) {
            throw new EquipmentStateNotFoundException();
        }

        return earningsRepository.findByPk_state_id(stateId)
                .stream()
                .map(HourlyEarningsDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public HourlyEarningsDTO findById(String hourlyEarningsId) {
        HourlyEarningsPK hourlyEarningsPK = extractPrimaryKey(hourlyEarningsId);
        return earningsRepository.findById(hourlyEarningsPK)
                .map(HourlyEarningsDTO::new)
                .orElseThrow(HourlyEarningsNotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(String hourlyEarningsId) {
        HourlyEarningsPK hourlyEarningsPK = extractPrimaryKey(hourlyEarningsId);

        HourlyEarnings hourlyEarningsFound = earningsRepository.findById(hourlyEarningsPK)
                .orElseThrow(HourlyEarningsNotFoundException::new);

        earningsRepository.delete(hourlyEarningsFound);
    }

    @Override
    @Transactional
    public void create(UUID stateId, HourlyEarningsCreateDTO hourlyEarningsCreate) {
        EquipmentState equipmentStateFound = equipmentStateRepository.findById(stateId)
                .orElseThrow(EquipmentStateNotFoundException::new);

        EquipmentModel equipmentModelFound = equipmentModelRepository.findById(UUID.fromString(hourlyEarningsCreate.getModelId()))
                .orElseThrow(EquipmentModelNotFoundException::new);

        HourlyEarningsPK hourlyEarningsPK = new HourlyEarningsPK(equipmentStateFound, equipmentModelFound);

        if (earningsRepository.existsById(hourlyEarningsPK)) {
            throw new HourlyEarningsAlreadyExistsException();
        }

        HourlyEarnings hourlyEarnings = new HourlyEarnings(hourlyEarningsPK, hourlyEarningsCreate.getValue());
        earningsRepository.save(hourlyEarnings);
    }

    @Override
    @Transactional
    public void update(String hourlyEarningsId, HourlyEarningsUpdateDTO hourlyEarningsUpdate) {
        HourlyEarningsPK hourlyEarningsPK = extractPrimaryKey(hourlyEarningsId);
        HourlyEarnings hourlyEarningsFound = earningsRepository.findById(hourlyEarningsPK)
                .orElseThrow(HourlyEarningsNotFoundException::new);

        hourlyEarningsFound.setValue(hourlyEarningsUpdate.getValue());
        earningsRepository.save(hourlyEarningsFound);
    }

    private HourlyEarningsPK extractPrimaryKey(String hourlyEarningsId) {
        if (!isHourlyEarningsIdValid(hourlyEarningsId)) {
            throw new InvalidHourlyEarningsIdException();
        }

        String[] idSplit = hourlyEarningsId.split("_");
        UUID stateId = UUID.fromString(idSplit[0]);
        UUID modelId = UUID.fromString(idSplit[1]);

        EquipmentState equipmentStateFound = equipmentStateRepository.findById(stateId)
                .orElseThrow(EquipmentStateNotFoundException::new);

        EquipmentModel equipmentModelFound = equipmentModelRepository.findById(modelId)
                .orElseThrow(EquipmentModelNotFoundException::new);

        return new HourlyEarningsPK(equipmentStateFound, equipmentModelFound);
    }

    @Override
    public boolean isHourlyEarningsIdValid(String hourlyEarningsId) {
        try {
            String[] idSplit = hourlyEarningsId.split("_");
            if (idSplit.length != 2) {
                return false;
            }
            UUID.fromString(idSplit[0]);
            UUID.fromString(idSplit[1]);

            return true;

        } catch (RuntimeException e) {
            return false;

        }
    }
}
