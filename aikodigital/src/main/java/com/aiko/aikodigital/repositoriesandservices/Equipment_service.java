package com.aiko.aikodigital.repositoriesandservices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.aikodigital.enties.Equipment;

@Service
public class Equipment_service {
@Autowired
private EquipmentRepository repository;
public Equipment create (Equipment em) {
	return repository.save(em);
}

public List<Equipment> getAllEm (){
	return repository.findAll();
}

public void delete (Equipment em) {
	repository.delete(em);
}

public Optional<Equipment> findById (UUID id) {
	return repository.findById(id);
}
}