package com.aikoprocesso.api.repository;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aikoprocesso.api.model.Equipment;

public interface EquipamentoRepository extends JpaRepository<Equipment, UUID> {
	
	//METODO QUE PROCURA POR ID
	
	
}
