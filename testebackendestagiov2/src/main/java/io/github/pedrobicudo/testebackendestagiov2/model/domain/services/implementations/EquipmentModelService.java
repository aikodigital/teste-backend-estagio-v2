package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentModelNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentModelService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentModelService implements IEquipmentModelService {

    @Autowired
    private EquipmentModelRepository repository;

    @Override
    @Transactional(readOnly = true)
    public EquipmentModelDTO findById(UUID id) {
        return repository.findById(id)
                .map(EquipmentModelDTO::new)
                .orElseThrow(EquipmentModelNotFoundException::new);
    }

    @Override
    @Transactional
    public void update(UUID id, EquipmentModelUpdateDTO equipmentModel) {
        EquipmentModel equipmentModelFound = repository.findById(id)
                .orElseThrow(EquipmentModelNotFoundException::new);

        equipmentModelFound.setName(equipmentModel.getName());
        repository.save(equipmentModelFound);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        EquipmentModel equipmentModelFound = repository.findById(id)
                .orElseThrow(EquipmentModelNotFoundException::new);

        repository.delete(equipmentModelFound);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipmentModelDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(EquipmentModelDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(EquipmentModelCreateDTO equipmentModel) {
        EquipmentModel equipmentModelCreate = new EquipmentModel();
        equipmentModelCreate.setName(equipmentModel.getName());

        repository.save(equipmentModelCreate);
    }
}
