package com.app.project.services;

import com.app.project.domain.EquipmentState;
import com.app.project.mapper.EquipmentMapper;
import com.app.project.repositories.EquipStateRepository;
import com.app.project.requests.equipState.EquipStatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentStateService {

    private final EquipStateRepository repository;

    private final EquipmentMapper mapper = EquipmentMapper.INSTANCE;


    public EquipmentState save(EquipStatePostRequest postRequest) {
        return repository.save(mapper.toEquipment(postRequest));
    }
}
