package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.HistoricoEstadoEquipamento;

public interface HistoricoEstadoEquipamentoRepositorio extends JpaRepository<HistoricoEstadoEquipamento, Long> {
    
}