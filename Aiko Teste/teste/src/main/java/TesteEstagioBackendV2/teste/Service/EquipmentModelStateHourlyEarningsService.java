package TesteEstagioBackendV2.teste.Service;
import TesteEstagioBackendV2.teste.Model.EquipmentModelStateHourlyEarnings;
import TesteEstagioBackendV2.teste.Repository.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelStateHourlyEarningsService {

    @Autowired
    private EquipmentModelStateHourlyEarningsRepository equipment_model_state_hourly_earnings_repository;

    @Transactional
    public EquipmentModelStateHourlyEarnings save(EquipmentModelStateHourlyEarnings equipment_model_state_hourly_earnings){
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipment_model = equipment_model_state_hourly_earnings_repository
                .findById(equipment_model_state_hourly_earnings.getId());
        if(optionalEquipment_model.isPresent()){

        }
        return equipment_model_state_hourly_earnings_repository.save(equipment_model_state_hourly_earnings);
    }
    @Transactional
    public EquipmentModelStateHourlyEarnings update(EquipmentModelStateHourlyEarnings equipment_model_state_hourly_earnings){
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipment_model_state_hourly_earnings = equipment_model_state_hourly_earnings_repository
                .findById(equipment_model_state_hourly_earnings.getId());
        if (!optionalEquipment_model_state_hourly_earnings.isPresent()){

        }
        return equipment_model_state_hourly_earnings_repository.save(equipment_model_state_hourly_earnings);
    }
    @Transactional
    public EquipmentModelStateHourlyEarnings getById(UUID id){
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipment_model_state_hourly_earnings = equipment_model_state_hourly_earnings_repository
                .findById(id);
        if (!optionalEquipment_model_state_hourly_earnings.isPresent()){

        }
        return optionalEquipment_model_state_hourly_earnings.get();
    }
    @Transactional
    public List<EquipmentModelStateHourlyEarnings> getAll(){
        return equipment_model_state_hourly_earnings_repository.findAll();
    }
    @Transactional
    public EquipmentModelStateHourlyEarnings delete(UUID id){
        Optional<EquipmentModelStateHourlyEarnings> optionalEquipment_model_state_hourly_earnings = equipment_model_state_hourly_earnings_repository
                .findById(id);
        if(optionalEquipment_model_state_hourly_earnings.isPresent()){
            equipment_model_state_hourly_earnings_repository.delete(optionalEquipment_model_state_hourly_earnings.get());
        }
        return optionalEquipment_model_state_hourly_earnings.get();
    }
}
