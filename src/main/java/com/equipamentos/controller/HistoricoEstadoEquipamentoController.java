package com.equipamentos.controller;

import java.util.Collections;
import java.util.Comparator;
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

import com.equipamentos.model.HistoricoEstadoEquipamento;
import com.equipamentos.service.HistoricoEstadoEquipamentoServico;

@RestController
@RequestMapping("/equipamentos/estados")
public class HistoricoEstadoEquipamentoController {

	@Autowired
	private HistoricoEstadoEquipamentoServico historicoEstadoEquipamentoServico;
	
	@GetMapping("/equipamentos/estado/recente")
	public ResponseEntity<List<HistoricoEstadoEquipamento>> listarEstadosRecente() {
		List<HistoricoEstadoEquipamento> listaEquipamento = historicoEstadoEquipamentoServico.listarTodos();
		Comparator<HistoricoEstadoEquipamento> equipamentosMaisRecente = (c1, c2) -> { 
				return c2.getData().compareTo(c1.getData());  };
		Collections.sort(listaEquipamento, equipamentosMaisRecente);	 	
		
		if(listaEquipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(listaEquipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping
	public ResponseEntity<List<HistoricoEstadoEquipamento>> listarTodos() {
		List<HistoricoEstadoEquipamento> equipamento = historicoEstadoEquipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(historicoEstadoEquipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<HistoricoEstadoEquipamento> buscarPorId(@PathVariable Long id) {
		HistoricoEstadoEquipamento equipamento = historicoEstadoEquipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<HistoricoEstadoEquipamento> adicionar(@NonNull @RequestBody HistoricoEstadoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(historicoEstadoEquipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<HistoricoEstadoEquipamento> atualizar(@RequestBody HistoricoEstadoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(historicoEstadoEquipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		historicoEstadoEquipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
