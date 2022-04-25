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

import com.equipamentos.model.EstadoEquipamento;
import com.equipamentos.service.EstadoEquipamentoServico;

@RestController
@RequestMapping("/equipamentos/estados")
public class EstadoEquipamentoController {

	@Autowired
	private EstadoEquipamentoServico estadoEquipamentoServico;

	@GetMapping
	public ResponseEntity<List<EstadoEquipamento>> listarTodos() {
		List<EstadoEquipamento> equipamento = estadoEquipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estadoEquipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoEquipamento> buscarPorId(@PathVariable Long id) {
		EstadoEquipamento equipamento = estadoEquipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<EstadoEquipamento> adicionar(@NonNull @RequestBody EstadoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoEquipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<EstadoEquipamento> atualizar(@RequestBody EstadoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(estadoEquipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		estadoEquipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
