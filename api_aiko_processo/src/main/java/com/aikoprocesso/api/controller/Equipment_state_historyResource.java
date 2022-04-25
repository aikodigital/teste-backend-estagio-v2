package com.aikoprocesso.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.aikoprocesso.api.model.Equipment_state_history;
import com.aikoprocesso.api.repository.Equipment_state_historyRepository;



@RestController
@RequestMapping(value = "/apiprocesso/equipmentstate")

public class Equipment_state_historyResource {

	@Autowired
	Equipment_state_historyRepository equipment_state_historyRepository;
	
	//Procurar pelo id
		@GetMapping("/history/id/{id}")
		public Optional<Equipment_state_history> idEquipment_state_history(@PathVariable(value = "id") UUID id) {
			return equipment_state_historyRepository.findById(id);
		}
		
		// Ler 
		
		@GetMapping("/history")
		public List<Equipment_state_history> lerEquipment_state_histories(){
			return equipment_state_historyRepository.findAll();
		}
		
		//Criar 
		
		@PostMapping("/new")
		public Equipment_state_history criarEquipment_state_history(@RequestBody Equipment_state_history equipment_state_history) {
			return equipment_state_historyRepository.save(equipment_state_history);
		}
		
		//Editar
		
		@PutMapping("/edit")
		public Equipment_state_history editarEquipment_state_history(Equipment_state_history equipment_state_history) {
			return equipment_state_historyRepository.save(equipment_state_history);
		}
		
		//Deletar
		
		@DeleteMapping("/deleteid/{id}")
		public void deletarEquipment_state_history(@PathVariable(value = "id") UUID id) {
			equipment_state_historyRepository.deleteById(id);
		}
		
}
