package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.Equipamento;

public interface EquipamentoRepositorio extends JpaRepository<Equipamento, Long> {
    
}