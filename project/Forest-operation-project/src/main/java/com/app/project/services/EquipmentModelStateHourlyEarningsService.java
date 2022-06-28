package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipModelStateHourlyEarningsRepository;
import com.app.project.requests.EquipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentModelStateHourlyEarningsService {

    private final EquipModelStateHourlyEarningsRepository repository;

    private final EquipmentModelService modelService;

    private final EquipmentStateService stateService;

    public EquipmentModelStateHourlyEarnings save(EquipModelStateHourlyEarningsPostRequest postRequest) throws NotFoundException {
        return repository.save(toRelateEntitiesInfos(postRequest));
    }

    private EquipmentModelStateHourlyEarnings toRelateEntitiesInfos(EquipModelStateHourlyEarningsPostRequest postRequest) throws NotFoundException {
        EquipmentModel equipModel = modelService.findByIdOrThrowsNotFoundException(postRequest.getEquipmentModelId());
        EquipmentState equipState = stateService.findByIdOrThrowsNotFoundException(postRequest.getEquipmentStateId());

        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = EquipmentModelStateHourlyEarnings.builder()
                .equipmentModel(equipModel)
                .equipmentState(equipState)
                .value(postRequest.getValue())
                .build();
        return equipmentModelStateHourlyEarnings;
    }

    public List<EquipmentModelStateHourlyEarnings> findAll() {
        return repository.findAll();
    }

    public EquipmentModelStateHourlyEarnings findByIdOrThrowsNotFoundException(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment state model hourly earning not found"));
    }
}
