package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipmentModelRepository;
import com.app.project.requests.EquipmentModelPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentModelService {

    private final EquipmentModelRepository modelRepository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<EquipmentModel> findAll() {
        return modelRepository.findAll();
    }

    public EquipmentModel findById(Long id) throws NotFoundException {
        EquipmentModel equipmentModel = modelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("equipment model not found"));
        return equipmentModel;
    }

    public EquipmentModel save(EquipmentModelPostRequest equipmentModelPostRequest) {
        return modelRepository.save(mapper.toEquipmentModel(equipmentModelPostRequest));
    }
}
