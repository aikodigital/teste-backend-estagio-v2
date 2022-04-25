package com.equipamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equipamentos.model.ModeloEquipamento;
import com.equipamentos.service.ModeloEquipamentoServico;

@RestController
@RequestMapping("/equipamentos/modelos")
public class ModeloEquipamentoController {

	@Autowired
	private ModeloEquipamentoServico modeloEquipamentoServico;

	@GetMapping
	public ResponseEntity<List<ModeloEquipamento>> listarTodos() {
		List<ModeloEquipamento> equipamento = modeloEquipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(modeloEquipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModeloEquipamento> buscarPorId(@PathVariable Long id) {
		ModeloEquipamento equipamento = modeloEquipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<ModeloEquipamento> adicionar(@NonNull @RequestBody ModeloEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(modeloEquipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<ModeloEquipamento> atualizar(@RequestBody ModeloEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(modeloEquipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		modeloEquipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
