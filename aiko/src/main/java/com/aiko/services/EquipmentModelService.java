package com.aiko.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.domain.EquipmentModel;
import com.aiko.repositories.EquipmentModelRepository;

@Service
public class EquipmentModelService {
	
	@Autowired
	private EquipmentModelRepository repo;
	
	public EquipmentModel find(UUID id) {
		Optional<EquipmentModel> equipmentModel = repo.findById(id);
		return equipmentModel.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  EquipmentModel.class.getName(), null));
	}
	
	public List<EquipmentModel> findAll() {
		return repo.findAll();
	}
	
	public EquipmentModel save(EquipmentModel equipmentModel) {
		return repo.save(equipmentModel);
	}
	
	public EquipmentModel update(EquipmentModel newEquipmentModel) {
		EquipmentModel equipmentModel = find(newEquipmentModel.getId());
		equipmentModel.setName(newEquipmentModel.getName());
		return repo.save(equipmentModel);
	}
	
	public void delete(UUID id) {
		EquipmentModel equipmentModel = find(id);
		repo.delete(equipmentModel);
	}
	
}
