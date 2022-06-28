package TesteEstagioBackendV2.teste.Service;

import TesteEstagioBackendV2.teste.Model.EquipmentModel;
import TesteEstagioBackendV2.teste.Repository.EquipmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelService {

    @Autowired
    private EquipmentModelRepository equipment_model_repository;

    @Transactional
    public EquipmentModel save(EquipmentModel equipment_model){
        Optional<EquipmentModel> optionalEquipment_model = equipment_model_repository.findById(equipment_model.getId());
        if(optionalEquipment_model.isPresent()){

        }
        return equipment_model_repository.save(equipment_model);
    }
    @Transactional
    public EquipmentModel update(EquipmentModel equipment_model){
        Optional<EquipmentModel> optionalEquipment_model = equipment_model_repository.findById(equipment_model.getId());
        if (!optionalEquipment_model.isPresent()){

        }
        return equipment_model_repository.save(equipment_model);
    }
    @Transactional
    public EquipmentModel getById(UUID id){
        Optional<EquipmentModel> optionalEquipment_model = equipment_model_repository.findById(id);
        if (!optionalEquipment_model.isPresent()){

        }
        return optionalEquipment_model.get();
    }
    @Transactional
    public List<EquipmentModel> getAll(){
        return equipment_model_repository.findAll();
    }
    @Transactional
    public EquipmentModel delete(UUID id){
        Optional<EquipmentModel> optionalEquipment_model = equipment_model_repository.findById(id);
        if(optionalEquipment_model.isPresent()){
            equipment_model_repository.delete(optionalEquipment_model.get());
        }
        return optionalEquipment_model.get();
    }

}
