package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.Equipment;
import com.br.raf.equipments.entities.EquipmentPositionHistory;
import com.br.raf.equipments.exceptions.ConflictException;
import com.br.raf.equipments.repositories.EquipmentPositionHistoryRepository;
import com.br.raf.equipments.repositories.EquipmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EquipmentPositionHistoryService {
    private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
    private final EquipmentRepository equipmentRepository;

    public EquipmentPositionHistoryService(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository, EquipmentRepository equipmentRepository) {
        this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public Set<EquipmentPositionHistory> getAll() {
        return equipmentPositionHistoryRepository.findAll(Sort.by(Sort.Direction.DESC,"date")).stream().collect(Collectors.toSet());
    }

    @Transactional
    public EquipmentPositionHistory save(EquipmentPositionHistory equipmentPositionHistory){
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentPositionHistory.getEquipmentId());
        if(optionalEquipment.isEmpty())
            throw new ConflictException("Equipment does not exist for this position!");

        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    public List<EquipmentPositionHistory> findById(UUID id) {
        return equipmentPositionHistoryRepository.findByEquipmentId(id);
    }

    public EquipmentPositionHistory findByDate(LocalDateTime dateTime) {
        Optional<EquipmentPositionHistory> optionalEquipmentPositionHistory =
                Optional.ofNullable(equipmentPositionHistoryRepository.findByDate(dateTime));
        if(!optionalEquipmentPositionHistory.isPresent()){
            throw new RuntimeException("Date not found!");
        }
        return equipmentPositionHistoryRepository.findByDate(dateTime);
    }

    public void delete(EquipmentPositionHistory equipmentPositionHistory){
        equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
    }
}
