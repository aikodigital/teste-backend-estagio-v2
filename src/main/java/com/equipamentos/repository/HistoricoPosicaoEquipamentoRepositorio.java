package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.HistoricoPosicaoEquipamento;

public interface HistoricoPosicaoEquipamentoRepositorio extends JpaRepository<HistoricoPosicaoEquipamento, Long> {
    
}