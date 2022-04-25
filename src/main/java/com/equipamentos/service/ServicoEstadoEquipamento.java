package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.EstadoEquipamento;

public interface ServicoEstadoEquipamento {

	EstadoEquipamento salvar(EstadoEquipamento estadoEquipamento);

    List<EstadoEquipamento> listarTodos(); 

    EstadoEquipamento buscarPorId(Long id); 

    EstadoEquipamento atualizar(EstadoEquipamento estadoEquipamento);

    void deletarPorId(Long id); 
    
}
