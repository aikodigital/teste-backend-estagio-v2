package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipPositionHistoryRepository;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
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

    public EquipmentPositionHistory save(EquipPositionHistoryPostRequest postRequest) throws NotFoundException {
        return repository.save(toRelateEntitiesInfos(postRequest));
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

    public List<EquipmentPositionHistory> findAll() {
        return repository.findAll();
    }

    public EquipmentPositionHistory findById(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("equipment position history not found"));
    }
}
