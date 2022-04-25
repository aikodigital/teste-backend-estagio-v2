package com.aikoprocesso.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aikoprocesso.api.model.Equipment_position_history;
import com.aikoprocesso.api.repository.Equipment_position_historyRepository;

import io.swagger.annotations.Api;



@RestController
@RequestMapping(value = "/api")

public class Equipment_position_historyResource {
	
	@Autowired
	Equipment_position_historyRepository equipment_position_historyRepository;
	
	//Procurar pelo id
	@GetMapping("/equipmentposition/history/id/{id}")
	public Optional<Equipment_position_history> idEquipment_position_history(@PathVariable(value = "id") UUID id) {
		return equipment_position_historyRepository.findById(id);
	}
	
	// Ler 
	
	@GetMapping("/equipmentposition/history")
	public List<Equipment_position_history> lerEquipment_position_histories(){
		return equipment_position_historyRepository.findAll();
	}
	
	//Criar 
	
	@PostMapping("/equipmentposition/new")
	public Equipment_position_history criarEquipment_position_history(@RequestBody Equipment_position_history equipment_position_history) {
		return equipment_position_historyRepository.save(equipment_position_history);
	}
	
	//Editar
	
	@PutMapping("/equipmentposition/edit")
	public Equipment_position_history editarEquipment_position_history(Equipment_position_history equipment_position_history) {
		return equipment_position_historyRepository.save(equipment_position_history);
	}
	
	//Deletar
	
	@DeleteMapping("/equipmentposition/deleteid/{id}")
	public void deletarEquipment_position_history(@PathVariable(value = "id") UUID id) {
		equipment_position_historyRepository.deleteById(id);
	}
	

}
