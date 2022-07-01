package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.EquipmentStateHistory;
import com.br.raf.equipments.repositories.EquipmentStateHistoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EquipmentStateHistoryService {
    private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    public EquipmentStateHistoryService(EquipmentStateHistoryRepository equipmentStateHistoryRepository) {
        this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
    }

    public Set<EquipmentStateHistory> findAll() {
        return equipmentStateHistoryRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Transactional
    public EquipmentStateHistory save(EquipmentStateHistory equipmentStateHistory){
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    public Optional<EquipmentStateHistory> findByEquipmentId(UUID equipmentId) {
        Optional<EquipmentStateHistory> optionalEquipmentStateHistory = Optional.ofNullable(equipmentStateHistoryRepository.findByEquipmentId(equipmentId));
        if(!optionalEquipmentStateHistory.isPresent()){
            throw new RuntimeException("Id not found!");
        }
        return Optional.ofNullable(equipmentStateHistoryRepository.findByEquipmentId(equipmentId));
    }

    public Optional<EquipmentStateHistory> findByEquipmentStateId(UUID equipmentStateId) {
        Optional<EquipmentStateHistory> optionalEquipmentStateHistory = Optional.ofNullable(equipmentStateHistoryRepository.findByEquipmentStateId(equipmentStateId));
        if(!optionalEquipmentStateHistory.isPresent()){
            throw new RuntimeException("Id not found!");
        }
        return Optional.ofNullable(equipmentStateHistoryRepository.findByEquipmentStateId(equipmentStateId));
    }

    public EquipmentStateHistory findByDate(LocalDateTime dateTime) {
        var obj = equipmentStateHistoryRepository.findByDate(dateTime);
        return equipmentStateHistoryRepository.findByDate(dateTime);
    }

    public void delete(EquipmentStateHistory equipmentStateHistory){
        equipmentStateHistoryRepository.delete(equipmentStateHistory);
    }
}
