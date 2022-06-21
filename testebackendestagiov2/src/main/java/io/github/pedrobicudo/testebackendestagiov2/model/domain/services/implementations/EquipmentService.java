package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentModelNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    @Override
    @Transactional(readOnly = true)
    public EquipmentDTO findById(UUID id) {
        return equipmentRepository.findById(id)
                .map(EquipmentDTO::new)
                .orElseThrow(EquipmentNotFoundException::new);
    }

    @Override
    @Transactional
    public void update(UUID id, EquipmentUpdateDTO equipment) {
        EquipmentModel model = equipmentModelRepository.findById(
                UUID.fromString(equipment.getModelId())
        )
                .orElseThrow(EquipmentModelNotFoundException::new);

        Equipment equipmentUpdate = equipmentRepository.findById(id)
                .orElseThrow(EquipmentNotFoundException::new);

        equipmentUpdate.setName(equipment.getName());
        equipmentUpdate.setEquipmentModel(model);

        equipmentRepository.save(equipmentUpdate);

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Equipment equipmentFound = equipmentRepository.findById(id)
                .orElseThrow(EquipmentNotFoundException::new);

        equipmentRepository.delete(equipmentFound);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipmentDTO> findAll() {
        return equipmentRepository.findAll()
                .stream()
                .map(EquipmentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(EquipmentCreateDTO equipment) {
        EquipmentModel model = equipmentModelRepository.findById(
                        UUID.fromString(equipment.getModelId())
                )
                .orElseThrow(EquipmentModelNotFoundException::new);

        Equipment equipmentCreate = new Equipment(
            null, equipment.getName(), model
        );

        equipmentRepository.save(equipmentCreate);

    }
}
