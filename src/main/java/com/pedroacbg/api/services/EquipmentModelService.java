package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentModel;
import com.pedroacbg.api.repository.EquipmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelService {

    @Autowired
    private EquipmentModelRepository repository;

    public List<EquipmentModel> findAll(){
        return repository.findAll();
    }

    public EquipmentModel findById(UUID id){
        Optional<EquipmentModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("Objeto não encontrado no sistema."));
    }

    @Transactional
    public EquipmentModel insert(EquipmentModel obj){
        return repository.save(obj);
    }

    @Transactional
    public EquipmentModel update(EquipmentModel obj){
        EquipmentModel newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(UUID id){
        findById(id);
        try{
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível deletar pois há entidades relacionadas!");
        }
    }


    public void updateData(EquipmentModel newObj, EquipmentModel obj){
        newObj.setName(obj.getName());
    }



}
