package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.HistoricoEstadoEquipamento;

public interface ServicoHistoricoEstadoEquipamento {

	HistoricoEstadoEquipamento salvar(HistoricoEstadoEquipamento historicoEstadoEquipamento);

    List<HistoricoEstadoEquipamento> listarTodos(); 

    HistoricoEstadoEquipamento buscarPorId(Long id); 

    HistoricoEstadoEquipamento atualizar(HistoricoEstadoEquipamento historicoEstadoEquipamento);

    void deletarPorId(Long id); 
    
}
