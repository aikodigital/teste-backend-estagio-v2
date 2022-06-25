package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipmentModelRepository;
import com.app.project.requests.EquipmentModelPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentModelService {

    private final EquipmentModelRepository modelRepository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public EquipmentModel save(EquipmentModelPostRequest equipmentModelPostRequest) {
        EquipmentModel equipmentModel = mapper.toEquipmentModel(equipmentModelPostRequest);
        return modelRepository.save(equipmentModel);
    }
}
