package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.EstadoModeloValorEquipamento;

public interface ServicoEstadoModeloValorEquipamento {

	EstadoModeloValorEquipamento salvar(EstadoModeloValorEquipamento estadoModeloValorEquipamento);

    List<EstadoModeloValorEquipamento> listarTodos(); 

    EstadoModeloValorEquipamento buscarPorId(Long id); 

    EstadoModeloValorEquipamento atualizar(EstadoModeloValorEquipamento estadoModeloValorEquipamento);

    void deletarPorId(Long id); 
    
}
