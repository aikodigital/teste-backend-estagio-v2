package com.equipamentos.service;

import java.util.List;

import com.equipamentos.model.Equipamento;

public interface Servico<T> {

	T salvar(T equipamento);

    List<T> listarTodos(); 

    T buscarPorId(Long id); 

    T atualizar(T equipamento);

    void deletarPorId(Long id); 
    
}
