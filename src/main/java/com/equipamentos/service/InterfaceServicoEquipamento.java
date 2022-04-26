package com.equipamentos.service;

import java.util.List;

public interface InterfaceServicoEquipamento<T> {

	T salvar(T equipamento);

    List<T> listarTodos(); 

    T buscarPorId(Long id); 

    T atualizar(T equipamento);

    void deletarPorId(Long id); 
    
}
