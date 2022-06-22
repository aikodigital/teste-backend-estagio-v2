package com.pedroacbg.api.services;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.repository.EquipmentModelRepository;
import com.pedroacbg.api.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }

    public Equipment findById(UUID id){
        Optional<Equipment> obj = equipmentRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("Objeto não encontrado no sistema."));
    }

    @Transactional
    public Equipment insert(Equipment obj){
      return equipmentRepository.save(obj);
    }

    @Transactional
    public Equipment update(Equipment obj){
        Equipment newObj = findById(obj.getId());
        updateData(newObj, obj);
        return equipmentRepository.save(newObj);
    }

    public void delete(UUID id){
        findById(id);
        try{
            equipmentRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível deletar pois há entidades relacionadas!");
        }
    }


    private void updateData(Equipment newObj, Equipment obj) {
        newObj.setName(obj.getName());
        newObj.setEquipmentModel(obj.getEquipmentModel());
    }
}
