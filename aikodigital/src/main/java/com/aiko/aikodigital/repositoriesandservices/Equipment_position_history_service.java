package com.aiko.aikodigital.repositoriesandservices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.aikodigital.enties.Equipment_position_history;

@Service
public class Equipment_position_history_service {

	@Autowired
	private Equipment_position_historyRepository repository;
	public Equipment_position_history create (Equipment_position_history em) {
		return repository.save(em);
	}

	public List<Equipment_position_history> list (){
		return repository.findAll();
	}

	public void delete (Equipment_position_history em) {
		repository.delete(em);
	}

	public Optional<Equipment_position_history> findById (UUID id) {
		return repository.findById(id);
	}
	
}
