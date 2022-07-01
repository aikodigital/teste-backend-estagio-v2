package com.br.raf.equipments.services;

import com.br.raf.equipments.entities.EquipmentModelStateHourlyEarnings;
import com.br.raf.equipments.repositories.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentModelStateHourlyEarningsService {
    private final EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    public EquipmentModelStateHourlyEarningsService(EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository) {
        this.equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
    }

    public List<EquipmentModelStateHourlyEarnings> findAll() {
        return equipmentModelStateHourlyEarningsRepository.findAll();
    }

    @Transactional
    public EquipmentModelStateHourlyEarnings save(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        return equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
    }

    public EquipmentModelStateHourlyEarnings findByValue(Integer value) {
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipmentModelStateHourlyEarnings =
                Optional.ofNullable(equipmentModelStateHourlyEarningsRepository.findByValue(value));
        if(!optionalEquipmentModelStateHourlyEarnings.isPresent()){
            throw new RuntimeException("Value not found!");
        }
        return equipmentModelStateHourlyEarningsRepository.findByValue(value);
    }

    public void delete(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        equipmentModelStateHourlyEarningsRepository.delete(equipmentModelStateHourlyEarnings);
    }
}
