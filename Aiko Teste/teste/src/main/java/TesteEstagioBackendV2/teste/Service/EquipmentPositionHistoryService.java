package TesteEstagioBackendV2.teste.Service;

import TesteEstagioBackendV2.teste.Model.EquipmentPositionHistory;
import TesteEstagioBackendV2.teste.Model.EquipmentStateHistory;
import TesteEstagioBackendV2.teste.Repository.EquipmentPositionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentPositionHistoryService {

    @Autowired
    private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    @Transactional
    public EquipmentPositionHistory save(EquipmentPositionHistory equipmentPositionHistory){
        Optional<EquipmentPositionHistory> optionalEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(equipmentPositionHistory.getId());
        if(optionalEquipmentPositionHistory.isPresent()){

        }
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }
    @Transactional
    public EquipmentPositionHistory update(EquipmentPositionHistory equipmentPositionHistory){
        Optional<EquipmentPositionHistory> optionalEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(equipmentPositionHistory.getId());
        if (!optionalEquipmentPositionHistory.isPresent()){

        }
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }
    @Transactional
    public EquipmentPositionHistory getById(UUID id){
        Optional<EquipmentPositionHistory> optionalEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(id);
        if (!optionalEquipmentPositionHistory.isPresent()){

        }
        return optionalEquipmentPositionHistory.get();
    }
    @Transactional
    public List<EquipmentPositionHistory> getAll(){
        return equipmentPositionHistoryRepository.findAll();
    }
    @Transactional
    public EquipmentPositionHistory delete(UUID id){
        Optional<EquipmentPositionHistory> optionalEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(id);
        if(optionalEquipmentPositionHistory.isPresent()){
            equipmentPositionHistoryRepository.delete(optionalEquipmentPositionHistory.get());
        }
        return optionalEquipmentPositionHistory.get();
    }
    @Transactional
    public List<EquipmentPositionHistory> getRecent (){
        Optional<List<EquipmentPositionHistory>> optionalEquipmentPositionHistory = equipmentPositionHistoryRepository.findMoreRecent();
        if (!optionalEquipmentPositionHistory.isPresent()){

        }
        return  optionalEquipmentPositionHistory.get();
    }
}
