package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.StateHistory;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.StateHistoryPK;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentStateNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidStateHistoryIdException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.StateHistoryNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.StateHistoryRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IStateHistoryService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StateHistoryService implements IStateHistoryService {

    @Autowired
    private StateHistoryRepository stateHistoryRepository;

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StateHistoryDTO> findAll(UUID equipmentId) {
        return stateHistoryRepository.findByPk_equipment_id(equipmentId)
                .stream()
                .map(StateHistoryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StateHistoryDTO current(UUID equipmentId) {
        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);

        Date mostRecentDate = stateHistoryRepository.findMostRecentDateFromEquipment(equipmentId);

        StateHistoryPK pk = new StateHistoryPK(equipmentFound, mostRecentDate);

        return stateHistoryRepository.findById(pk)
                .map(StateHistoryDTO::new)
                .orElseThrow(StateHistoryNotFoundException::new);

    }

    @Override
    @Transactional(readOnly = true)
    public StateHistoryDTO findById(String stateHistoryId) {
        StateHistoryPK stateHistoryPK = extractPrimaryKey(stateHistoryId);
        return stateHistoryRepository.findById(stateHistoryPK)
                .map(StateHistoryDTO::new)
                .orElseThrow(StateHistoryNotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(String stateHistoryId) {
        StateHistoryPK stateHistoryPK = extractPrimaryKey(stateHistoryId);

        StateHistory stateHistoryFound = stateHistoryRepository.findById(stateHistoryPK)
                .orElseThrow(StateHistoryNotFoundException::new);

        stateHistoryRepository.delete(stateHistoryFound);
    }

    @Override
    @Transactional
    public void create(UUID equipmentId, StateHistoryCreateDTO stateHistoryCreate) {
        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);

        EquipmentState equipmentStateFound = equipmentStateRepository.findById(
                UUID.fromString(stateHistoryCreate.getStateId())
        )
                .orElseThrow(EquipmentStateNotFoundException::new);

        StateHistoryPK stateHistoryPK = new StateHistoryPK(
                equipmentFound,
                new Date()
        );

        StateHistory stateHistory = new StateHistory(
                stateHistoryPK,
                equipmentStateFound
        );

        stateHistoryRepository.save(stateHistory);
    }

    @Override
    @Transactional
    public void update(String stateHistoryId, StateHistoryUpdateDTO stateHistoryUpdate) {
        StateHistoryPK stateHistoryPK = extractPrimaryKey(stateHistoryId);
        EquipmentState equipmentStateReplace = equipmentStateRepository.findById(
                        UUID.fromString(stateHistoryUpdate.getStateId())
                )
                .orElseThrow(EquipmentStateNotFoundException::new);
        StateHistory stateHistoryFound = stateHistoryRepository.findById(stateHistoryPK)
                .orElseThrow(StateHistoryNotFoundException::new);

        stateHistoryFound
                .setState(equipmentStateReplace);

        stateHistoryRepository.save(stateHistoryFound);

    }

    @Transactional(readOnly = true)
    private StateHistoryPK extractPrimaryKey(String stateHistoryId) {
        if (!isStateHistoryIdValid(stateHistoryId)) {
            throw new InvalidStateHistoryIdException();
        }

        String[] idSplit = stateHistoryId.split("_");
        UUID equipmentId = UUID.fromString(idSplit[0]);
        Date date = new Date(Long.parseLong(idSplit[1]));

        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);

        return new StateHistoryPK(equipmentFound, date);
    }

    @Override
    public boolean isStateHistoryIdValid(String stateHistoryId) {
        try {
            String[] idSplit = stateHistoryId.split("_");
            if (idSplit.length != 2) {
                return false;
            }
            UUID.fromString(idSplit[0]);
            Long.parseLong(idSplit[1]);

            return true;

        } catch (RuntimeException e) {
            return false;

        }
    }
}
