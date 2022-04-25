package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.ModeloEquipamento;

public interface ServicoModeloEquipamento {

	ModeloEquipamento salvar(ModeloEquipamento modeloEquipamento);

    List<ModeloEquipamento> listarTodos(); 

    ModeloEquipamento buscarPorId(Long id); 

    ModeloEquipamento atualizar(ModeloEquipamento modeloEquipamento);

    void deletarPorId(Long id); 
    
}
