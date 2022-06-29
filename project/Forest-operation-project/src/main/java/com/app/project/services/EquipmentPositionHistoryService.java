package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipPositionHistoryRepository;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentPositionHistoryService {

    private final EquipPositionHistoryRepository repository;

    private final EquipmentService service;

    private EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<EquipmentPositionHistory> findAll() {
        return repository.findAll();
    }

    public EquipmentPositionHistory findByIdOrThrowsNotFoundException(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("equipment position history not found"));
    }

    public EquipmentPositionHistory save(EquipPositionHistoryPostRequest postRequest) throws NotFoundException {
        return repository.save(toRelateEntitiesInfos(postRequest));
    }

    public void update(EquipPositionHistoryPutRequest putRequest) throws NotFoundException {
        repository.save(toRelateEntitiesInfos(putRequest));
    }

    public void delete(UUID id) throws NotFoundException {
        EquipmentPositionHistory equipPositionHistoryFounded = findByIdOrThrowsNotFoundException(id);
        repository.delete(equipPositionHistoryFounded);
    }

    private EquipmentPositionHistory toRelateEntitiesInfos(EquipPositionHistoryPostRequest postRequest) throws NotFoundException {
        Equipment equip = service.findByIdOrThrowNotFoundException(postRequest.getEquipment());

        EquipmentPositionHistory equipmentPositionHistory = EquipmentPositionHistory.builder()
                .equipment(equip)
                .date(LocalDateTime.now())
                .lat(postRequest.getLat())
                .lon(postRequest.getLon())
                .build();
        return equipmentPositionHistory;
    }

    private EquipmentPositionHistory toRelateEntitiesInfos(EquipPositionHistoryPutRequest putRequest) throws NotFoundException {
        Equipment equip = service.findByIdOrThrowNotFoundException(putRequest.getEquipment());

        EquipmentPositionHistory equipmentPositionHistory = EquipmentPositionHistory.builder()
                .id(putRequest.getId())
                .equipment(equip)
                .date(LocalDateTime.now())
                .lat(putRequest.getLat())
                .lon(putRequest.getLon())
                .build();
        return equipmentPositionHistory;
    }
}
