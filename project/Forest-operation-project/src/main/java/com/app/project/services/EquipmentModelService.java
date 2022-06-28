package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipModelRepository;
import com.app.project.requests.equipModel.EquipmentModelPostRequest;
import com.app.project.requests.equipModel.EquipmentModelPutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentModelService {

    private final EquipModelRepository modelRepository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<EquipmentModel> findAll() {
        return modelRepository.findAll();
    }

    public EquipmentModel findByIdOrThrowNotFoundException(UUID id) throws NotFoundException {
        EquipmentModel equipmentModel = modelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("equipment model not found"));
        return equipmentModel;
    }

    public EquipmentModel save(EquipmentModelPostRequest equipmentModelPostRequest) {
        return modelRepository.save(mapper.toEquipment(equipmentModelPostRequest));
    }

    public void update(EquipmentModelPutRequest putRequest) throws NotFoundException {
        EquipmentModel savedEquipModel = findByIdOrThrowNotFoundException(putRequest.getId());
        EquipmentModel equipModel = mapper.toEquipment(putRequest);
        equipModel.setId(savedEquipModel.getId());
        modelRepository.save(equipModel);
    }

    public void delete(UUID id) throws NotFoundException {
        EquipmentModel equipToDelete = findByIdOrThrowNotFoundException(id);
        modelRepository.delete(equipToDelete);
    }
}
