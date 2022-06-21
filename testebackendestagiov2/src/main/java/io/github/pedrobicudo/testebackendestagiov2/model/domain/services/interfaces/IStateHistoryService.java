package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IStateHistoryService {
    List<StateHistoryDTO> findAll(UUID equipmentId);
    StateHistoryDTO current(UUID equipmentId);
    StateHistoryDTO findById(String stateHistoryId);
    void delete(String stateHistoryId);
    void create(UUID equipmentId, StateHistoryCreateDTO stateHistoryCreate);
    boolean isStateHistoryIdValid(String stateHistoryId);
    void update(String stateHistoryId, StateHistoryUpdateDTO stateHistoryUpdate);

}
