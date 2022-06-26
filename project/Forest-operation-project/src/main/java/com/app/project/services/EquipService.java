package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipRepository;
import com.app.project.requests.equip.EquipPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipService {

    private final EquipRepository repository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public Equipment save(EquipPostRequest equipmentPostRequest) {
        return repository.save(mapper.toEquipment(equipmentPostRequest));
    }

    public List<Equipment> findAll() {
        return repository.findAll();
    }
}
