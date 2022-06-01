package com.aiko.testebackendestagiov2.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentModel;
import com.aiko.testebackendestagiov2.models.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.models.EquipmentState;
import com.aiko.testebackendestagiov2.models.pk.EquipmentModelStateHourlyEarningsPK;
import com.aiko.testebackendestagiov2.repositories.EquipmentModelRepository;
import com.aiko.testebackendestagiov2.repositories.EquipmentModelStateHourlyEarningsRepository;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateRepository;

import org.springframework.stereotype.Service;

@Service
public class EquipmentModelStateHourlyEarningsService {

    private EquipmentModelStateHourlyEarningsRepository earningsRepository;
    private EquipmentModelRepository modelRepository;
    private EquipmentStateRepository stateRepository;

    public EquipmentModelStateHourlyEarningsService(EquipmentModelStateHourlyEarningsRepository earningsRepository,
            EquipmentModelRepository modelRepository, EquipmentStateRepository stateRepository) {
        this.earningsRepository = earningsRepository;
        this.modelRepository = modelRepository;
        this.stateRepository = stateRepository;
    }

    public List<EquipmentModelStateHourlyEarnings> findAll() {
        return earningsRepository.findAll();
    }

    public EquipmentModelStateHourlyEarnings findById(UUID modelId, UUID stateId) {
        EquipmentModel equipmentModel = modelRepository.findById(modelId).get();
        EquipmentState equipmentState = stateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        try{
            return earningsRepository.findById(id).get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public EquipmentModelStateHourlyEarnings save(EquipmentModelStateHourlyEarnings obj) {
        EquipmentModel equipmentModel = obj.getEquipmentModel();
        EquipmentState equipmentState = obj.getEquipmentState();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        boolean earningsCheck = earningsRepository.findById(id).isPresent();
        if(earningsCheck){
            return null;
        }else{
            return earningsRepository.save(obj);
        }
    }

    public EquipmentModelStateHourlyEarnings update(UUID modelId, UUID stateId, EquipmentModelStateHourlyEarnings obj) {
        EquipmentModel equipmentModel = modelRepository.findById(modelId).get();
        EquipmentState equipmentState = stateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        EquipmentModelStateHourlyEarnings earningsToUpdate = earningsRepository.findById(id).get();
        earningsToUpdate.setValue(obj.getValue());
        return earningsRepository.save(earningsToUpdate);
    }

    public void deleteById(UUID modelId, UUID stateId) {
        EquipmentModel equipmentModel = modelRepository.findById(modelId).get();
        EquipmentState equipmentState = stateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        earningsRepository.deleteById(id);
    }

}