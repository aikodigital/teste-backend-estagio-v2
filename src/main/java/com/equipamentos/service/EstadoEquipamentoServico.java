package com.equipamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipamentos.model.EstadoEquipamento;
import com.equipamentos.repository.EstadoEquipamentoRepositorio;

@Service
public abstract class EstadoEquipamentoServico implements InterfaceServicoEquipamento<EstadoEquipamento> {

	@Autowired
    private EstadoEquipamentoRepositorio estadoEquipamentoRepositorio;

    public EstadoEquipamento salvar(EstadoEquipamento estadoEquipamento) {
        return estadoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public List<EstadoEquipamento> listarTodos() {
        return estadoEquipamentoRepositorio.findAll();
    }

    public EstadoEquipamento buscarPorId(Long id) {
        return estadoEquipamentoRepositorio.getOne(id);
    }

    public EstadoEquipamento atualizar(EstadoEquipamento estadoEquipamento) {
        return estadoEquipamentoRepositorio.save(estadoEquipamento);
    }

    public void deletarPorId(Long id) {
        estadoEquipamentoRepositorio.deleteById(id);
    }
}
