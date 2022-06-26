package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipRepository;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.requests.equip.EquipPutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipService {

    private final EquipRepository repository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<Equipment> findAll() {
        return repository.findAll();
    }

    public Equipment findByIdOrThrowNotFoundException(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("equipment Not Found"));
    }

    public Equipment save(EquipPostRequest equipmentPostRequest) {
        return repository.save(mapper.toEquipment(equipmentPostRequest));
    }

    public void update(EquipPutRequest putRequest) throws NotFoundException {
        Equipment equipmentFounded = findByIdOrThrowNotFoundException(putRequest.getId());
        Equipment equipmentToSave = mapper.toEquipment(putRequest);
        equipmentToSave.setId(equipmentFounded.getId());
        equipmentToSave.setModel(equipmentFounded.getModel());
        repository.save(equipmentToSave);
    }

    public void delete(Long id) throws NotFoundException {
        Equipment equipment = findByIdOrThrowNotFoundException(id);
        repository.delete(equipment);
    }
}
