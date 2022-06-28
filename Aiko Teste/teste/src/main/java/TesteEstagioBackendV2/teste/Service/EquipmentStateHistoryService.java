package TesteEstagioBackendV2.teste.Service;

import TesteEstagioBackendV2.teste.Model.EquipmentStateHistory;
import TesteEstagioBackendV2.teste.Repository.EquipmentStateHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentStateHistoryService {

    @Autowired
    private EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    @Transactional
    public EquipmentStateHistory save(EquipmentStateHistory equipment_state_history){
        Optional<EquipmentStateHistory> optionalEquipment_state_history = equipmentStateHistoryRepository.findById(equipment_state_history.getId());
        if(optionalEquipment_state_history.isPresent()){

        }
        return equipmentStateHistoryRepository.save(equipment_state_history);
    }
    @Transactional
    public EquipmentStateHistory update(EquipmentStateHistory equipment_state_history){
        Optional<EquipmentStateHistory> optionalEquipment_state_history = equipmentStateHistoryRepository.findById(equipment_state_history.getId());
        if (!optionalEquipment_state_history.isPresent()){

        }
        return equipmentStateHistoryRepository.save(equipment_state_history);
    }
    @Transactional
    public EquipmentStateHistory getById(UUID id){
        Optional<EquipmentStateHistory> optionalEquipment_state_history = equipmentStateHistoryRepository.findById(id);
        if (!optionalEquipment_state_history.isPresent()){

        }
        return optionalEquipment_state_history.get();
    }
    @Transactional
    public List<EquipmentStateHistory> getAll(){
        return equipmentStateHistoryRepository.findAll();
    }
    @Transactional
    public EquipmentStateHistory delete(UUID id){
        Optional<EquipmentStateHistory> optionalEquipment_state_history = equipmentStateHistoryRepository.findById(id);
        if(optionalEquipment_state_history.isPresent()){
            equipmentStateHistoryRepository.delete(optionalEquipment_state_history.get());
        }
        return optionalEquipment_state_history.get();
    }

    @Transactional
    public List<EquipmentStateHistory> getRecent (){
        Optional<List<EquipmentStateHistory>> optionalEquipmentStateHistory = equipmentStateHistoryRepository.findMoreRecent();
        if (!optionalEquipmentStateHistory.isPresent()){
            
        }
        return  optionalEquipmentStateHistory.get();
    }

}
