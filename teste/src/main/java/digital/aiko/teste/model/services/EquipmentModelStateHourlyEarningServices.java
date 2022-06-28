package digital.aiko.teste.model.services;

import org.springframework.stereotype.Service;

import digital.aiko.teste.model.entities.EquipmentModelStateHourlyEarnings;
import digital.aiko.teste.model.repositories.EquipmentModelStateHourlyEarningsRepository;

@Service
public class EquipmentModelStateHourlyEarningServices {

	private EquipmentModelStateHourlyEarningsRepository repository;

	public EquipmentModelStateHourlyEarningServices(EquipmentModelStateHourlyEarningsRepository repository) {
		this.repository = repository;
	}
	
	public EquipmentModelStateHourlyEarnings save(EquipmentModelStateHourlyEarnings equipmentModelStateHoulyEarnings) {
		return this.repository.save(equipmentModelStateHoulyEarnings);
	}
	

	public Iterable<EquipmentModelStateHourlyEarnings> findAll() {
		return this.repository.findAll();
	}


}
