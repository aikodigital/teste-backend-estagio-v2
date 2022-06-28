package TesteEstagioBackendV2.teste.Service;

import TesteEstagioBackendV2.teste.Model.EquipmentState;
import TesteEstagioBackendV2.teste.Repository.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentStateService {

    @Autowired
    private EquipmentStateRepository equipment_state_repository;

    @Transactional
    public EquipmentState save(EquipmentState equipment_state){
        Optional<EquipmentState> optionalEquipment_state = equipment_state_repository.findById(equipment_state.getId());
        if(optionalEquipment_state.isPresent()){

        }
        return equipment_state_repository.save(equipment_state);
    }
    @Transactional
    public EquipmentState update(EquipmentState equipment_state){
        Optional<EquipmentState> optionalEquipment_state = equipment_state_repository.findById(equipment_state.getId());
        if (!optionalEquipment_state.isPresent()){

        }
        return equipment_state_repository.save(equipment_state);
    }
    @Transactional
    public EquipmentState getById(UUID id){
        Optional<EquipmentState> optionalEquipment_state = equipment_state_repository.findById(id);
        if (!optionalEquipment_state.isPresent()){

        }
        return optionalEquipment_state.get();
    }
    @Transactional
    public List<EquipmentState> getAll(){
        return equipment_state_repository.findAll();
    }
    @Transactional
    public EquipmentState delete(UUID id){
        Optional<EquipmentState> optionalEquipment_state = equipment_state_repository.findById(id);
        if(optionalEquipment_state.isPresent()){
            equipment_state_repository.delete(optionalEquipment_state.get());
        }
        return optionalEquipment_state.get();
    }
}
