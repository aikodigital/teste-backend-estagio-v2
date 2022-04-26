package com.equipamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipamentos.model.HistoricoEstadoEquipamento;
import com.equipamentos.repository.HistoricoEstadoEquipamentoRepositorio;

@Service
public abstract class HistoricoEstadoEquipamentoServico implements InterfaceServicoEquipamento<HistoricoEstadoEquipamento> {

	@Autowired
    private HistoricoEstadoEquipamentoRepositorio historicoEstadoEquipamentoRepositorio;

    public HistoricoEstadoEquipamento salvar(HistoricoEstadoEquipamento estadoEquipamento) {
        return historicoEstadoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public List<HistoricoEstadoEquipamento> listarTodos() {
        return historicoEstadoEquipamentoRepositorio.findAll();
    }

    public HistoricoEstadoEquipamento buscarPorId(Long id) {
        return historicoEstadoEquipamentoRepositorio.getOne(id);
    }

    public HistoricoEstadoEquipamento atualizar(HistoricoEstadoEquipamento estadoEquipamento) {
        return historicoEstadoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public void deletarPorId(Long id) {
        historicoEstadoEquipamentoRepositorio.deleteById(id);
    }
}
