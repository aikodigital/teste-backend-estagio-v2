package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.repositories.EquipmentModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentModelService {
    private final EquipmentModelRepository modelRepository;

    public EquipmentModel save(EquipmentModel equipmentModel) {
        return modelRepository.save(equipmentModel);
    }

}
