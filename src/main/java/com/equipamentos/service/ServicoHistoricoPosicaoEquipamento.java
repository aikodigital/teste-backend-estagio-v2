package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.HistoricoPosicaoEquipamento;

public interface ServicoHistoricoPosicaoEquipamento {

	HistoricoPosicaoEquipamento salvar(HistoricoPosicaoEquipamento historicoPosicaoEquipamento);

    List<HistoricoPosicaoEquipamento> listarTodos(); 

    HistoricoPosicaoEquipamento buscarPorId(Long id); 

    HistoricoPosicaoEquipamento atualizar(HistoricoPosicaoEquipamento historicoPosicaoEquipamento);

    void deletarPorId(Long id); 
    
}
