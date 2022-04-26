package com.equipamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipamentos.model.HistoricoPosicaoEquipamento;
import com.equipamentos.repository.HistoricoPosicaoEquipamentoRepositorio;

@Service
public abstract class HistoricoPosicaoEquipamentoServico implements InterfaceServicoEquipamento<HistoricoPosicaoEquipamento> {

	@Autowired
    private HistoricoPosicaoEquipamentoRepositorio historicoPosicaoEquipamentoRepositorio;

    public HistoricoPosicaoEquipamento salvar(HistoricoPosicaoEquipamento estadoEquipamento) {
        return historicoPosicaoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public List<HistoricoPosicaoEquipamento> listarTodos() {
        return historicoPosicaoEquipamentoRepositorio.findAll();
    }

    public HistoricoPosicaoEquipamento buscarPorId(Long id) {
        return historicoPosicaoEquipamentoRepositorio.getOne(id);
    }

    public HistoricoPosicaoEquipamento atualizar(HistoricoPosicaoEquipamento estadoEquipamento) {
        return historicoPosicaoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public void deletarPorId(Long id) {
        historicoPosicaoEquipamentoRepositorio.deleteById(id);
    }
}
