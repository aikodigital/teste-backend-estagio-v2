package com.equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipamentos.model.EstadoModeloValorEquipamento;

public interface EstadoModeloValorEquipamentoRepositorio extends JpaRepository<EstadoModeloValorEquipamento, Long> {
    
}