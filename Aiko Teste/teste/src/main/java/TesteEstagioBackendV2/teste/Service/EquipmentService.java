package TesteEstagioBackendV2.teste.Service;

import TesteEstagioBackendV2.teste.Model.Equipment;
import TesteEstagioBackendV2.teste.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentrepository;

    @Transactional
    public Equipment save(Equipment equipment){
        Optional<Equipment> optionalEquipment = equipmentrepository.findById(equipment.getId());
        if(optionalEquipment.isPresent()){

        }
        return equipmentrepository.save(equipment);
    }
    @Transactional
    public Equipment update(Equipment equipment){
        Optional<Equipment> optionalEquipment = equipmentrepository.findById(equipment.getId());
        if (!optionalEquipment.isPresent()){

        }
        return equipmentrepository.save(equipment);
    }
    @Transactional
    public Equipment getById(UUID id){
        Optional<Equipment> optionalEquipment = equipmentrepository.findById(id);
        if (!optionalEquipment.isPresent()){

        }
        return optionalEquipment.get();
    }
    @Transactional
    public List<Equipment> getAll(){
        return equipmentrepository.findAll();
    }

    @Transactional
    public Equipment delete(UUID id){
        Optional<Equipment> optionalEquipment = equipmentrepository.findById(id);
        if(optionalEquipment.isPresent()){
            equipmentrepository.delete(optionalEquipment.get());
        }
        return optionalEquipment.get();
    }



}
