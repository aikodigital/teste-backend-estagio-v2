package com.equipamentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipamentos.model.ModeloEquipamento;
import com.equipamentos.repository.ModeloEquipamentoRepositorio;

@Service
public abstract class ModeloEquipamentoServico implements Servico {

	@Autowired
    private ModeloEquipamentoRepositorio modeloEquipamentoRepositorio;

    public ModeloEquipamento salvar(ModeloEquipamento modeloEquipamento) {
        return modeloEquipamentoRepositorio.save(modeloEquipamento);
    }

    public List<ModeloEquipamento> listarTodos() {
        return modeloEquipamentoRepositorio.findAll();
    }

    public ModeloEquipamento buscarPorId(Long id) {
        return modeloEquipamentoRepositorio.getById(id);
    }

    public ModeloEquipamento atualizar(ModeloEquipamento modeloEquipamento) {
        return modeloEquipamentoRepositorio.save(modeloEquipamento);
    }

    public void deletarPorId(Long id) {
        modeloEquipamentoRepositorio.deleteById(id);
    }
}
