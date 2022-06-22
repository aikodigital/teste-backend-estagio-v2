package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentState;
import com.pedroacbg.api.repository.EquipmentModelRepository;
import com.pedroacbg.api.repository.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentStateService {

    @Autowired
    private EquipmentStateRepository repository;

    public List<EquipmentState> findAll(){
        return repository.findAll();
    }

    public EquipmentState findById(UUID id){
        Optional<EquipmentState> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("Objeto não encontrado no sistema."));
    }

    @Transactional
    public EquipmentState insert(EquipmentState obj){
        return repository.save(obj);
    }

    @Transactional
    public EquipmentState update(EquipmentState obj){
        EquipmentState newObj = findById(obj.getId());
        updateState(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(UUID id){
        findById(id);
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível deletar pois há entidades relacionadas!");
        }
    }

    public void updateState(EquipmentState newObj, EquipmentState obj){
        newObj.setName(obj.getName());
        newObj.setColor(obj.getColor());
    }

}
