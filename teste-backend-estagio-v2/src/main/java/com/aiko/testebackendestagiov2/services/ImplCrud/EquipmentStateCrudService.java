package com.aiko.testebackendestagiov2.services.ImplCrud;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentStateRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import com.aiko.testebackendestagiov2.enums.EquipmentStateList;
import com.aiko.testebackendestagiov2.exceptions.BusinessException;
import com.aiko.testebackendestagiov2.exceptions.NotFoundError;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentStateCrudService implements ICrudService<EquipmentState, EquipmentStateRequest> {

    private final EquipmentStateRepository equipmentStateRepository;

    @Override
    public List<EquipmentState> getAll() {
        return equipmentStateRepository.findAll();
    }

    @Override
    public EquipmentState getById(UUID id) {
        return equipmentStateRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundError("Don't exist Equipment State with this id " + id));
    }

    @Override
    public EquipmentState create(EquipmentStateRequest request) {
        EquipmentState equipmentState = new EquipmentState();
        Map<String, String> nameAndColor = getEquipmentStateNameAndColor(request);
        equipmentState.setName(nameAndColor.get("name"));
        equipmentState.setColor(nameAndColor.get("color"));
        return equipmentStateRepository.save(equipmentState);
    }

    @Override
    public EquipmentState update(UUID id, EquipmentStateRequest request) {
        EquipmentState equipmentState = this.getById(id);
        Map<String, String> nameAndColor = getEquipmentStateNameAndColor(request);
        equipmentState.setName(nameAndColor.get("name"));
        equipmentState.setColor(nameAndColor.get("color"));
        return equipmentStateRepository.save(equipmentState);
    }

    @Override
    public void delete(UUID id) {
        equipmentStateRepository.deleteById(id);
    }

    private Map<String,String> getEquipmentStateNameAndColor(EquipmentStateRequest request){
        Map<String,String> atributes = new HashMap<>();
        String name = null;
        String color = null;
        if (request.getName().toUpperCase().equals(EquipmentStateList.MANUTENCAO.getName())){
            name = EquipmentStateList.MANUTENCAO.getName();
            color = EquipmentStateList.MANUTENCAO.getColor();
        } else if(request.getName().toUpperCase().equals(EquipmentStateList.PARADO.getName())){
            name = EquipmentStateList.PARADO.getName();
            color = EquipmentStateList.PARADO.getColor();
        } else if(request.getName().toUpperCase().equals(EquipmentStateList.OPERANDO.getName())){
            name = EquipmentStateList.OPERANDO.getName();
            color = EquipmentStateList.OPERANDO.getColor();
        }
        if (name == null || color == null){
            throw new BusinessException("Inputs valids to Equipment State name: Operando, Parado or Manutenção");
        }
        atributes.put("name",name);
        atributes.put("color",color);
        return atributes;
    }
}
