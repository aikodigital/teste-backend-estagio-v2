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

import com.equipamentos.model.EstadoModeloValorEquipamento;
import com.equipamentos.service.EstadoModeloValorEquipamentoServico;

@RestController
@RequestMapping("/equipamentos/estados/valor-hora")
public class EstadoModeloValorEquipamentoController {

	@Autowired
	private EstadoModeloValorEquipamentoServico estadoModeloValorEquipamentoServico;

	@GetMapping
	public ResponseEntity<List<EstadoModeloValorEquipamento>> listarTodos() {
		List<EstadoModeloValorEquipamento> equipamento = estadoModeloValorEquipamentoServico.listarTodos(); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estadoModeloValorEquipamentoServico.listarTodos());	
		}
		return ResponseEntity.notFound().build(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoModeloValorEquipamento> buscarPorId(@PathVariable Long id) {
		EstadoModeloValorEquipamento equipamento = estadoModeloValorEquipamentoServico.buscarPorId(id); 
		if(equipamento != null) {
			return ResponseEntity.status(HttpStatus.OK).body(equipamento);	
		}
		return ResponseEntity.notFound().build(); 
	}

	@PostMapping
	public ResponseEntity<EstadoModeloValorEquipamento> adicionar(@NonNull @RequestBody EstadoModeloValorEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoModeloValorEquipamentoServico.salvar(equipamento));
	}

	@PutMapping
	public ResponseEntity<EstadoModeloValorEquipamento> atualizar(@RequestBody EstadoModeloValorEquipamento equipamento) {
		return ResponseEntity.status(HttpStatus.OK).body(estadoModeloValorEquipamentoServico.atualizar(equipamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		estadoModeloValorEquipamentoServico.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
