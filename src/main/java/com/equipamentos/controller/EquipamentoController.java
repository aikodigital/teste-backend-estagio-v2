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

import com.equipamentos.model.Equipamento;
import com.equipamentos.service.EquipamentoServico;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

	@Autowired
	private EquipamentoServico equipamentoServico;

	@GetMapping
	public ResponseEntity<List<Equipamento>> listarTodos() {
		List<Equipamento> equipamento = equipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<Equipamento> buscarPorId(@PathVariable Long id) {
		Equipamento equipamento = equipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<Equipamento> adicionar(@NonNull @RequestBody Equipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<Equipamento> atualizar(@RequestBody Equipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(equipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		equipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
