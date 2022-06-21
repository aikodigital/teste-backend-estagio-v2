package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IEquipmentModelService {

    EquipmentModelDTO findById(UUID id);
    void update(UUID id, EquipmentModelUpdateDTO equipmentModel);
    void delete(UUID id);
    void create(EquipmentModelCreateDTO equipmentModel);
    List<EquipmentModelDTO> findAll();
}
