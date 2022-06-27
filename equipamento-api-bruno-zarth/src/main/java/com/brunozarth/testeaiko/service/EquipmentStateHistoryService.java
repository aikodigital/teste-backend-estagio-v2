package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.EquipmentStateHistory;
import com.brunozarth.testeaiko.model.EquipmentStateHistoryId;
import com.brunozarth.testeaiko.repository.EquipmentStateHistoryRepository;
import com.brunozarth.testeaiko.requests.equipmentStateHistory.EquipmentStateHistoryPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentStateHistory.EquipmentStateHistoryPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentStateHistoryService {

    private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    @Autowired
    public EquipmentStateHistoryService(
            EquipmentStateHistoryRepository equipmentStateHistoryRepository){
        this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
    }

    public List<EquipmentStateHistory> findAll(){
        return equipmentStateHistoryRepository.findAll();
    }

    public EquipmentStateHistory findByIdOrThrowBadRequestException(EquipmentStateHistoryId id){
        return equipmentStateHistoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment state history id not found!"));
    }

    public List<EquipmentStateHistory> findByEquipmentId(UUID id){
        return equipmentStateHistoryRepository.findByIdEquipmentId(id);
    }

    public List<EquipmentStateHistory> findByEquipmentStateId(UUID id){
        return equipmentStateHistoryRepository.findByIdEquipmentStateId(id);
    }

    public EquipmentStateHistory saveEquipmentStateHistory(
            EquipmentStateHistoryPostRequestBody equipmentStateHistoryPostRequestBody){

        EquipmentStateHistory equipmentStateHistory = EquipmentStateHistory.builder()
                .id(equipmentStateHistoryPostRequestBody.getId())
                .date(equipmentStateHistoryPostRequestBody.getDate())
                .build();

        equipmentStateHistoryRepository.save(equipmentStateHistory);
        this.findByIdOrThrowBadRequestException(equipmentStateHistory.getId());
        return equipmentStateHistory;
    }

    public void deleteEquipmentStateHistoryById(EquipmentStateHistoryId id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentStateHistoryRepository.deleteById(id);
    }

    public EquipmentStateHistory replaceEquipmentStateHistory(EquipmentStateHistoryPutRequestBody equipmentStateHistoryPutRequestBody) {
        EquipmentStateHistory savedEquipmentStateHistory = this.findByIdOrThrowBadRequestException(equipmentStateHistoryPutRequestBody.getId());
        EquipmentStateHistory equipmentStateHistory = EquipmentStateHistory.builder()
                .id(equipmentStateHistoryPutRequestBody.getId())
                .date(equipmentStateHistoryPutRequestBody.getDate())
                .build();

        equipmentStateHistoryRepository.save(equipmentStateHistory);
        return equipmentStateHistory;
    }
}
