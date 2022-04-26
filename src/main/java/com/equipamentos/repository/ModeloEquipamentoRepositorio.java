package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.ModeloEquipamento;

public interface ModeloEquipamentoRepositorio extends JpaRepository<ModeloEquipamento, Long> {
    
}