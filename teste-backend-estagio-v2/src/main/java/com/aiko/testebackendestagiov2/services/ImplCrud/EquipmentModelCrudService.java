package com.aiko.testebackendestagiov2.services.ImplCrud;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentModelRequest;
import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import com.aiko.testebackendestagiov2.exceptions.NotFoundError;
import com.aiko.testebackendestagiov2.repositories.EquipmentModelRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentModelCrudService implements ICrudService<EquipmentModel, EquipmentModelRequest> {

    private final EquipmentModelRepository equipmentModelRepository;

    @Override
    public List<EquipmentModel> getAll() {
        return equipmentModelRepository.findAll();
    }

    @Override
    public EquipmentModel getById(UUID id) {
        return equipmentModelRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("Don't exist Equipment Model with this id " + id));
    }

    @Override
    public EquipmentModel create(EquipmentModelRequest request) {
        EquipmentModel equipmentModel = new EquipmentModel();
        equipmentModel.setName(request.getName());
        return equipmentModelRepository.save(equipmentModel);
    }

    @Override
    public EquipmentModel update(UUID id, EquipmentModelRequest request) {
        EquipmentModel equipmentModel = this.getById(id);
        equipmentModel.setName(request.getName());
        return equipmentModelRepository.save(equipmentModel);
    }

    @Override
    public void delete(UUID id) {
        equipmentModelRepository.deleteById(id);
    }
}
