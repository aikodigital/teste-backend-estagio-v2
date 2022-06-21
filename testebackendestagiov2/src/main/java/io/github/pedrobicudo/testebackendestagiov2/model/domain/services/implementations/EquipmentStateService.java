package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentStateNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentStateService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentStateService implements IEquipmentStateService {

    @Autowired
    private EquipmentStateRepository repository;

    @Override
    @Transactional(readOnly = true)
    public EquipmentStateDTO findById(UUID id) {
        return repository.findById(id)
                .map(EquipmentStateDTO::new)
                .orElseThrow(EquipmentStateNotFoundException::new);
    }

    @Override
    @Transactional
    public void update(UUID id, EquipmentStateUpdateDTO equipmentState) {
        EquipmentState equipmentStateFound = repository.findById(id)
                .orElseThrow(EquipmentStateNotFoundException::new);

        equipmentStateFound.setName(equipmentState.getName());
        equipmentStateFound.setColor(equipmentState.getColor());
        repository.save(equipmentStateFound);

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        EquipmentState equipmentStateFound = repository.findById(id)
                .orElseThrow(EquipmentStateNotFoundException::new);

        repository.delete(equipmentStateFound);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipmentStateDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(EquipmentStateDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(EquipmentStateCreateDTO equipmentState) {
        EquipmentState equipmentStateCreate = new EquipmentState();
        equipmentStateCreate.setName(equipmentState.getName());
        equipmentStateCreate.setColor(equipmentState.getColor());

        repository.save(equipmentStateCreate);
    }
}
