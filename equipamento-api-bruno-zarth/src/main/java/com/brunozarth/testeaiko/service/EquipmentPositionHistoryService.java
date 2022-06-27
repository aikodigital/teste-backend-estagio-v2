package com.brunozarth.testeaiko.service;

import com.brunozarth.testeaiko.exception.BadRequestException;
import com.brunozarth.testeaiko.model.EquipmentPositionHistory;
import com.brunozarth.testeaiko.model.EquipmentPositionHistoryId;
import com.brunozarth.testeaiko.repository.EquipmentPositionHistoryRepository;
import com.brunozarth.testeaiko.requests.equipmentPositionHistory.EquipmentPositionHistoryPostRequestBody;
import com.brunozarth.testeaiko.requests.equipmentPositionHistory.EquipmentPositionHistoryPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentPositionHistoryService {

    private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    @Autowired
    public EquipmentPositionHistoryService(
            EquipmentPositionHistoryRepository equipmentPositionHistoryRepository){
        this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
    }

    public List<EquipmentPositionHistory> findAll(){
        return equipmentPositionHistoryRepository.findAll();
    }

    public EquipmentPositionHistory findByIdOrThrowBadRequestException(EquipmentPositionHistoryId id){
        return equipmentPositionHistoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Equipment state history id not found!"));
    }

    public List<EquipmentPositionHistory> findByEquipmentId(UUID id){
        return equipmentPositionHistoryRepository.findByIdEquipmentId(id);
    }

    public EquipmentPositionHistory saveEquipmentPositionHistory(
            EquipmentPositionHistoryPostRequestBody equipmentPositionHistoryPostRequestBody){

        EquipmentPositionHistory equipmentPositionHistory = EquipmentPositionHistory.builder()
                .id(equipmentPositionHistoryPostRequestBody.getId())
                .lat(equipmentPositionHistoryPostRequestBody.getLat())
                .lon(equipmentPositionHistoryPostRequestBody.getLon())
                .build();

        equipmentPositionHistoryRepository.save(equipmentPositionHistory);
        this.findByIdOrThrowBadRequestException(equipmentPositionHistory.getId());
        return equipmentPositionHistory;
    }

    public void deleteEquipmentPositionHistoryById(EquipmentPositionHistoryId id){
        this.findByIdOrThrowBadRequestException(id);
        equipmentPositionHistoryRepository.deleteById(id);
    }

    public EquipmentPositionHistory replaceEquipmentPositionHistory(EquipmentPositionHistoryPutRequestBody equipmentPositionHistoryPutRequestBody) {
        EquipmentPositionHistory savedEquipmentPositionHistory = this.findByIdOrThrowBadRequestException(equipmentPositionHistoryPutRequestBody.getId());
        EquipmentPositionHistory equipmentPositionHistory = EquipmentPositionHistory.builder()
                .id(equipmentPositionHistoryPutRequestBody.getId())
                .lat(equipmentPositionHistoryPutRequestBody.getLat())
                .lon(equipmentPositionHistoryPutRequestBody.getLon())
                .build();

        equipmentPositionHistoryRepository.save(equipmentPositionHistory);
        return equipmentPositionHistory;
    }
}
