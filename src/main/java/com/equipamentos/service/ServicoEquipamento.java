package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.Equipamento;

public interface ServicoEquipamento {

	Equipamento salvar(Equipamento equipamento);

    List<Equipamento> listarTodos(); 

    Equipamento buscarPorId(Long id); 

    Equipamento atualizar(Equipamento equipamento);

    void deletarPorId(Long id); 
    
}
