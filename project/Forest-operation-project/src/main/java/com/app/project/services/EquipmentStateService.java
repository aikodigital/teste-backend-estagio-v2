package com.app.project.services;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipStateRepository;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.requests.equipState.EquipStatePutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentStateService {

    private final EquipStateRepository repository;


    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;

    public List<EquipmentState> findAll() {
        return repository.findAll();
    }

    public EquipmentState findByIdOrThrowsNotFoundException(UUID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment state not found"));
    }

    public EquipmentState save(EquipStatePostRequest postRequest) {
        return repository.save(mapper.toEquipment(postRequest));
    }

    public void update(EquipStatePutRequest putRequest) throws NotFoundException {
        EquipmentState equipFounded = findByIdOrThrowsNotFoundException(putRequest.getId());
        EquipmentState equipmentToSave = mapper.toEquipment(putRequest);
        equipmentToSave.setId(equipFounded.getId());
        repository.save(equipmentToSave);
    }

    public void delete(UUID id) throws NotFoundException {
        EquipmentState equipFounded = findByIdOrThrowsNotFoundException(id);
        repository.delete(equipFounded);
    }
}
