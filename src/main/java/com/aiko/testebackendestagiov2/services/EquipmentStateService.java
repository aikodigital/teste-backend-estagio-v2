package com.aiko.testebackendestagiov2.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentState;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateRepository;
import com.aiko.testebackendestagiov2.services.interfaces.StdCrudService;

import org.springframework.stereotype.Service;

@Service
public class EquipmentStateService implements StdCrudService<EquipmentState, UUID> {

    private EquipmentStateRepository stateRepository;

    public EquipmentStateService(EquipmentStateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @Override
    public List<EquipmentState> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public EquipmentState findById(UUID id) {
        try{
            return stateRepository.findById(id).get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public EquipmentState save(EquipmentState obj) {
        return stateRepository.save(obj);
    }

    @Override
    public EquipmentState update(UUID id, EquipmentState obj) {
        EquipmentState stateToUpdate = stateRepository.findById(id).get();
        stateToUpdate.setName(obj.getName());
        stateToUpdate.setColor(obj.getColor());
        return stateRepository.save(stateToUpdate);
    }

    @Override
    public void deleteById(UUID id) {
        stateRepository.deleteById(id);
    }

}