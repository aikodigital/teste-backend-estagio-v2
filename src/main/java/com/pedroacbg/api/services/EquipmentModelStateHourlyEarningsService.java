package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.EquipmentModel;
import com.pedroacbg.api.entities.EquipmentModelStateHourlyEarnings;
import com.pedroacbg.api.entities.EquipmentState;
import com.pedroacbg.api.pk.EquipmentModelStateHourlyEarningsPK;
import com.pedroacbg.api.repository.EquipmentModelRepository;
import com.pedroacbg.api.repository.EquipmentModelStateHourlyEarningsRepository;
import com.pedroacbg.api.repository.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelStateHourlyEarningsService {

    @Autowired
    private EquipmentModelStateHourlyEarningsRepository repository;

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    public List<EquipmentModelStateHourlyEarnings> findAll(){

        return repository.findAll();
    }

    public EquipmentModelStateHourlyEarnings findById(UUID modelId, UUID stateId){
        EquipmentModel equipmentModel = equipmentModelRepository.findById(modelId).get();
        EquipmentState equipmentState = equipmentStateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        Optional<EquipmentModelStateHourlyEarnings> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("Objeto não encontrado no sistema."));
    }

    public EquipmentModelStateHourlyEarnings insert(EquipmentModelStateHourlyEarnings obj){
        EquipmentModel equipmentModel = obj.getId().getEquipmentModel();
        EquipmentState equipmentState = obj.getId().getEquipmentState();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        return repository.save(obj);
    }

    public EquipmentModelStateHourlyEarnings update(UUID modelId, UUID stateId, EquipmentModelStateHourlyEarnings obj){
        EquipmentModel equipmentModel = equipmentModelRepository.findById(modelId).get();
        EquipmentState equipmentState = equipmentStateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        EquipmentModelStateHourlyEarnings earningsUpdate = repository.findById(id).get();
        earningsUpdate.setValue(obj.getValue());
        return repository.save(earningsUpdate);
    }

    public void delete(UUID modelId, UUID stateId){
        EquipmentModel equipmentModel = equipmentModelRepository.findById(modelId).get();
        EquipmentState equipmentState = equipmentStateRepository.findById(stateId).get();
        EquipmentModelStateHourlyEarningsPK id = new EquipmentModelStateHourlyEarningsPK(equipmentModel, equipmentState);
        repository.deleteById(id);
    }


}
