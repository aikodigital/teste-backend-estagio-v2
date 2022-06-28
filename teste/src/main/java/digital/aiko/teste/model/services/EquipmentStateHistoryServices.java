package digital.aiko.teste.model.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.Equipment;
import digital.aiko.teste.model.entities.EquipmentState;
import digital.aiko.teste.model.entities.EquipmentStateHistory;
import digital.aiko.teste.model.entities.ModelStateHistoryId;
import digital.aiko.teste.model.repositories.EquipmentStateHistoryRepository;

@Service
public class EquipmentStateHistoryServices {

	private EquipmentStateHistoryRepository repository;

	public EquipmentStateHistoryServices(EquipmentStateHistoryRepository repository) {
		this.repository = repository;
	}

	public EquipmentStateHistory save(EquipmentStateHistory equipmentStateHistory) {
		return this.repository.save(equipmentStateHistory);
	}


	
	public Iterable<EquipmentStateHistory> searchByIdLike(String equipment_id, String equipment_state_id){
		return this.repository.searchByIdLike(new ModelStateHistoryId(new Equipment(UUID.fromString(equipment_id))),new ModelStateHistoryId( new EquipmentState(UUID.fromString(equipment_state_id))));
	}

	public Iterable<EquipmentStateHistory> findAll() {
		return this.repository.findAll();
	}


}
