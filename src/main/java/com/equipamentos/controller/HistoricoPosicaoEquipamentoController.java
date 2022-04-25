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

import com.equipamentos.model.HistoricoPosicaoEquipamento;
import com.equipamentos.service.HistoricoPosicaoEquipamentoServico;

@RestController
@RequestMapping("/equipamentos/estados")
public class HistoricoPosicaoEquipamentoController {

	@Autowired
	private HistoricoPosicaoEquipamentoServico historicoPosicaoEquipamentoServico;

	@GetMapping("/equipamentos/posicao/recente")
	public ResponseEntity<List<HistoricoPosicaoEquipamento>> listarEstadosRecente() {
		List<HistoricoPosicaoEquipamento> listaEquipamento = historicoPosicaoEquipamentoServico.listarTodos();
		Comparator<HistoricoPosicaoEquipamento> equipamentosMaisRecente = (c1, c2) -> { 
				return c2.getData().compareTo(c1.getData());  };
		Collections.sort(listaEquipamento, equipamentosMaisRecente);	 	
		
		if(listaEquipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(listaEquipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@GetMapping
	public ResponseEntity<List<HistoricoPosicaoEquipamento>> listarTodos() {
		List<HistoricoPosicaoEquipamento> equipamento = historicoPosicaoEquipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(historicoPosicaoEquipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<HistoricoPosicaoEquipamento> buscarPorId(@PathVariable Long id) {
		HistoricoPosicaoEquipamento equipamento = historicoPosicaoEquipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<HistoricoPosicaoEquipamento> adicionar(@NonNull @RequestBody HistoricoPosicaoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(historicoPosicaoEquipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<HistoricoPosicaoEquipamento> atualizar(@RequestBody HistoricoPosicaoEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(historicoPosicaoEquipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		historicoPosicaoEquipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
