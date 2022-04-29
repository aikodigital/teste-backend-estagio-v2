package com.aiko.aikodigital.repositoriesandservices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.aikodigital.enties.Equipment_model_state_hourly_earnings;


	@Service
	public class Equipment_model_state_hourly_earning_service {
	@Autowired
	private Equipment_model_state_hourly_earningsRepository repository;
	public Equipment_model_state_hourly_earnings create (Equipment_model_state_hourly_earnings em) {
		return repository.save(em);
	}

	public List<Equipment_model_state_hourly_earnings> getAllEm (){
		return repository.findAll();
	}

	public void delete (Equipment_model_state_hourly_earnings em) {
		repository.delete(em);
	}

	public Optional<Equipment_model_state_hourly_earnings> findById (UUID id) {
		return repository.findById(id);
		
	}
	}

