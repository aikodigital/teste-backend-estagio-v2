package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipModelStateHourlyEarningsRepository;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPutRequest;
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

    public List<EquipmentModelStateHourlyEarnings> findAll() {
        return repository.findAll();
    }

    public EquipmentModelStateHourlyEarnings findByIdOrThrowsNotFoundException(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment state model hourly earning not found"));
    }

    public EquipmentModelStateHourlyEarnings save(EquipModelStateHourlyEarningsPostRequest postRequest) throws NotFoundException {
        return repository.save(toRelateEntitiesInfos(postRequest));
    }

    public void update(EquipModelStateHourlyEarningsPutRequest putRequest) throws NotFoundException {
        repository.save(toRelateEntitiesInfos(putRequest));
    }

    public void delete(UUID id) throws NotFoundException {
        EquipmentModelStateHourlyEarnings entityFounded = findByIdOrThrowsNotFoundException(id);
        repository.delete(entityFounded);
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

    private EquipmentModelStateHourlyEarnings toRelateEntitiesInfos(EquipModelStateHourlyEarningsPutRequest putRequest) throws NotFoundException {
        EquipmentModel equipModel = modelService.findByIdOrThrowsNotFoundException(putRequest.getEquipmentModelId());
        EquipmentState equipState = stateService.findByIdOrThrowsNotFoundException(putRequest.getEquipmentStateId());

        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = EquipmentModelStateHourlyEarnings.builder()
                .id(putRequest.getId())
                .equipmentModel(equipModel)
                .equipmentState(equipState)
                .value(putRequest.getValue())
                .build();
        return equipmentModelStateHourlyEarnings;
    }
}
