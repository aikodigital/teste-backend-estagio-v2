package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.PositionHistory;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.PositionHistoryPK;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidPositionHistoryIdException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.PositionHistoryNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.PositionHistoryRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IPositionHistoryService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryUpdateDTO;
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
public class PositionHistoryService implements IPositionHistoryService {

    @Autowired
    private PositionHistoryRepository positionRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PositionHistoryDTO> findAll(UUID equipmentId) {
        if (!equipmentRepository.existsById(equipmentId)) {
            throw new EquipmentNotFoundException();
        }

        return positionRepository.findByPk_equipment_id(equipmentId)
                .stream()
                .map(PositionHistoryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PositionHistoryDTO current(UUID equipmentId) {
        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);

        Date mostRecentDate = positionRepository.findByRecentDateFromEquipment(equipmentId);
        PositionHistoryPK pk = new PositionHistoryPK(
                equipmentFound,
                mostRecentDate
        );

        return positionRepository.findById(pk)
                .map(PositionHistoryDTO::new)
                .orElseThrow(PositionHistoryNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public PositionHistoryDTO findById(String positionHistoryId) {
        PositionHistoryPK pk = extractPrimaryKey(positionHistoryId);
        return positionRepository.findById(pk)
                .map(PositionHistoryDTO::new)
                .orElseThrow(PositionHistoryNotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(String positionHistoryId) {
        PositionHistoryPK pk = extractPrimaryKey(positionHistoryId);
        PositionHistory positionHistoryFound = positionRepository.findById(pk)
                .orElseThrow(PositionHistoryNotFoundException::new);
        positionRepository.delete(positionHistoryFound);
    }

    @Override
    @Transactional
    public void create(UUID equipmentId, PositionHistoryCreateDTO positionHistoryCreate) {
        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);

        PositionHistoryPK pk = new PositionHistoryPK(
                equipmentFound, new Date()
        );

        PositionHistory positionHistory = new PositionHistory(
                pk,
                positionHistoryCreate.getLat(),
                positionHistoryCreate.getLon()
        );

        positionRepository.save(positionHistory);

    }

    @Override
    @Transactional
    public void update(String positionHistoryId, PositionHistoryUpdateDTO positionHistoryUpdate) {
        PositionHistoryPK pk = extractPrimaryKey(positionHistoryId);

        PositionHistory positionHistory = positionRepository.findById(pk)
                .orElseThrow(PositionHistoryNotFoundException::new);

        positionHistory.setLat(positionHistoryUpdate.getLat());
        positionHistory.setLon(positionHistoryUpdate.getLon());

        positionRepository.save(positionHistory);
    }

    private PositionHistoryPK extractPrimaryKey(String positionHistoryId) {
        if (!isPositionHistoryIdValid(positionHistoryId)) {
            throw new InvalidPositionHistoryIdException();
        }
        String[] idSplit = positionHistoryId.split("_");
        UUID equipmentId = UUID.fromString(idSplit[0]);
        Date date = new Date(Long.parseLong(idSplit[1]));

        Equipment equipmentFound = equipmentRepository.findById(equipmentId)
                .orElseThrow(EquipmentNotFoundException::new);


        return new PositionHistoryPK(equipmentFound, date);
    }

    @Override
    public boolean isPositionHistoryIdValid(String positionHistoryId) {
        try {
            String[] idSplit = positionHistoryId.split("_");
            if (idSplit.length != 2) return false;

            UUID.fromString(idSplit[0]);
            Long.parseLong(idSplit[1]);

            return true;

        } catch (RuntimeException e) {
            return false;

        }
    }

}
