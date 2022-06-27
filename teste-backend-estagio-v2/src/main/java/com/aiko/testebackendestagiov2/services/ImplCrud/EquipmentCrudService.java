package com.aiko.testebackendestagiov2.services.ImplCrud;

import com.aiko.testebackendestagiov2.dtos.requests.EquipmentRequest;
import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import com.aiko.testebackendestagiov2.exceptions.NotFoundError;
import com.aiko.testebackendestagiov2.repositories.EquipmentRepository;
import com.aiko.testebackendestagiov2.services.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentCrudService implements ICrudService<Equipment, EquipmentRequest> {

    private final EquipmentModelCrudService equipmentModelCrudService;

    private final EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getById(UUID id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("Don't exist Equipment with this id " + id));
    }

    @Override
    public Equipment create(EquipmentRequest request) {
        EquipmentModel equipmentModel = equipmentModelCrudService.getById(request.getEquipmentModelId());
        Equipment equipment = new Equipment();
        equipment.setName(request.getName());
        equipment.setEquipmentModel(equipmentModel);
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment update(UUID id, EquipmentRequest request) {
        EquipmentModel equipmentModel = equipmentModelCrudService.getById(request.getEquipmentModelId());
        Equipment equipment = this.getById(id);
        equipment.setName(request.getName());
        equipment.setEquipmentModel(equipmentModel);
        return equipmentRepository.save(equipment);
    }

    @Override
    public void delete(UUID id) {
        equipmentRepository.deleteById(id);
    }
}
