package com.aiko.aikodigital.repositoriesandservices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.aikodigital.enties.Equipment_state;

@Service
public class Equipment_state_service {
@Autowired
private Equipment_stateRepository repository;
public Equipment_state create (Equipment_state em) {
	return repository.save(em);
}

public List<Equipment_state> getAllEm (){
	return repository.findAll();
}

public void delete (Equipment_state em) {
	repository.delete(em);
}

public Optional<Equipment_state> findById (UUID id) {
	return repository.findById(id);
}
}