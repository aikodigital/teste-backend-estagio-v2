package com.aiko.aikodigital.repositoriesandservices;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.aikodigital.enties.Equipment_model;

@Service
public class service {
@Autowired
private EquipmentModelRepository repository;
public Equipment_model create (Equipment_model em) {
	return repository.save(em);
}

public List<Equipment_model> getAllEm (){
	return repository.findAll();
}

public void delete (Equipment_model em) {
	repository.delete(em);
}

public Optional<Equipment_model> findById (UUID id) {
	return repository.findById(id);
}
}
