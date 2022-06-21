package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IEquipmentService {
    EquipmentDTO findById(UUID id);
    void update(UUID id, EquipmentUpdateDTO equipment);
    void delete(UUID id);
    void create(EquipmentCreateDTO equipment);
    List<EquipmentDTO> findAll();

}
