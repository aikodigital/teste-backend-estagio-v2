package com.aiko.testebackendestagiov2.services.ImplCrud;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentStateRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentState;
import com.aiko.testebackendestagiov2.exceptions.NotFoundError;
import com.aiko.testebackendestagiov2.repositories.EquipmentStateRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        equipmentState.setName(request.getName());
        equipmentState.setColor(request.getColor());
        return equipmentStateRepository.save(equipmentState);
    }

    @Override
    public EquipmentState update(UUID id, EquipmentStateRequest request) {
        EquipmentState equipmentState = this.getById(id);
        equipmentState.setName(request.getName());
        equipmentState.setColor(request.getColor());
        return equipmentStateRepository.save(equipmentState);
    }

    @Override
    public void delete(UUID id) {
        equipmentStateRepository.deleteById(id);
    }
}
