package com.equipamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipamentos.model.Equipamento;
import com.equipamentos.repository.EquipamentoRepositorio;

@Service
public abstract class EquipamentoServico implements InterfaceServicoEquipamento<Equipamento>{

	@Autowired
    private EquipamentoRepositorio repositorioEquipamento;

    public Equipamento salvar(Equipamento equipamento) {
        return repositorioEquipamento.save(equipamento);
    }

    public List<Equipamento> listarTodos() {
        return repositorioEquipamento.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return repositorioEquipamento.getOne(id);
    }

    public Equipamento atualizar(Equipamento equipamento) {
        return repositorioEquipamento.save(equipamento);
    }

    public void deletarPorId(Long id) {
        repositorioEquipamento.deleteById(id);
    }
}
