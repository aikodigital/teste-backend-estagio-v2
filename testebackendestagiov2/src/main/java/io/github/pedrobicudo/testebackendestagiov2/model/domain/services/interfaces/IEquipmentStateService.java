package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IEquipmentStateService {
    EquipmentStateDTO findById(UUID id);
    void update(UUID id, EquipmentStateUpdateDTO equipmentState);
    void delete(UUID id);
    void create(EquipmentStateCreateDTO equipmentState);
    List<EquipmentStateDTO> findAll();

}
