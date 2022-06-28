package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentState;
import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipStateHistoryRepository;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentStateHistoryService {

    private final EquipStateHistoryRepository repository;

    private final EquipmentService equipService;

    private final EquipmentStateService equipStateService;

    private EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<EquipmentStateHistory> findAll() {
        return repository.findAll();
    }

    public EquipmentStateHistory findById(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment state history not found"));
    }

    public EquipmentStateHistory save(EquipStateHistoryPostRequest equipStateHistory) throws NotFoundException {
        return repository.save(toRelateEntitiesInfos(equipStateHistory));
    }

    public void update(EquipStateHistoryPutRequest putRequest) throws NotFoundException {
        findById(putRequest.getId());
        repository.save(toRelateEntitiesInfos(putRequest));
    }

    private EquipmentStateHistory toRelateEntitiesInfos(EquipStateHistoryPostRequest postRequest) throws NotFoundException {
        Equipment equip = equipService.findByIdOrThrowNotFoundException(postRequest.getEquipmentId());
        EquipmentState equipState = equipStateService.findByIdOrThrowsNotFoundException(postRequest.getEquipmentStateId());

        EquipmentStateHistory equipmentStateHistory = EquipmentStateHistory.builder()
                .date(LocalDateTime.now())
                .equipment(equip)
                .equipmentState(equipState)
                .build();
        return equipmentStateHistory;
    }

    private EquipmentStateHistory toRelateEntitiesInfos(EquipStateHistoryPutRequest putRequest) throws NotFoundException {
        Equipment equip = equipService
                .findByIdOrThrowNotFoundException(putRequest.getEquipment().getId());
        EquipmentState equipState = equipStateService
                .findByIdOrThrowsNotFoundException(putRequest.getEquipmentState().getId());

        EquipmentStateHistory equipmentStateHistory = EquipmentStateHistory.builder()
                .id(putRequest.getId())
                .date(LocalDateTime.now())
                .equipment(equip)
                .equipmentState(equipState)
                .build();
        return equipmentStateHistory;
    }

    public void delete(UUID id) throws NotFoundException {
        EquipmentStateHistory entityToDeleteFounded = findById(id);
        repository.delete(entityToDeleteFounded);
    }
}
