package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.EstadoEquipamento;

public interface EstadoEquipamentoRepositorio extends JpaRepository<EstadoEquipamento, Long> {
    
}