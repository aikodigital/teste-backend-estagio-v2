package com.equipamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipamentos.model.EstadoModeloValorEquipamento;
import com.equipamentos.repository.EstadoModeloValorEquipamentoRepositorio;

@Service
public abstract class EstadoModeloValorEquipamentoServico implements Servico<EstadoModeloValorEquipamento> {

	@Autowired
    private EstadoModeloValorEquipamentoRepositorio estadoModeloValorEquipamentoRepositorio;

    public EstadoModeloValorEquipamento salvar(EstadoModeloValorEquipamento estadoModeloValorEquipamento) {
        return estadoModeloValorEquipamentoRepositorio.save(estadoModeloValorEquipamento);
    }

    public List<EstadoModeloValorEquipamento> listarTodos() {
        return estadoModeloValorEquipamentoRepositorio.findAll();
    }

    public EstadoModeloValorEquipamento buscarPorId(Long id) {
        return estadoModeloValorEquipamentoRepositorio.getById(id);
    }

    public EstadoModeloValorEquipamento atualizar(EstadoModeloValorEquipamento estadoModeloValorEquipamento) {
        return estadoModeloValorEquipamentoRepositorio.save(estadoModeloValorEquipamento);
    }

    public void deletarPorId(Long id) {
        estadoModeloValorEquipamentoRepositorio.deleteById(id);
    }
}
