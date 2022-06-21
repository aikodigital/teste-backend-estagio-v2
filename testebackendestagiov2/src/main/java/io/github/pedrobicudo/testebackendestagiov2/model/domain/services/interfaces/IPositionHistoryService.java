package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IPositionHistoryService {
    List<PositionHistoryDTO> findAll(UUID equipmentId);
    PositionHistoryDTO current(UUID equipmentId);
    PositionHistoryDTO findById(String positionHistoryId);
    void delete(String positionHistoryId);
    void create(UUID equipmentId, PositionHistoryCreateDTO positionHistoryCreate);
    void update(String positionHistoryId, PositionHistoryUpdateDTO positionHistoryUpdate);
    boolean isPositionHistoryIdValid(String positionHistoryId);
}
