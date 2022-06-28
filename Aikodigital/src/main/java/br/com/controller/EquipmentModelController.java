package br.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.DTO.EquipmentModelDTO;
import br.com.model.EquipmentModelEntity;
import br.com.repository.EquipmentModelRepository;

/**
 * Controller responsável pelos end points da classe EquipmentModel
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/equipmentModel")
public class EquipmentModelController {

	/**
	 * Injeção de dependência do repositório
	 */
	@Autowired
	private EquipmentModelRepository modelRepository;

	/**
	 * End point responsável pelo cadastro do modelo de equipamento no banco de dados 
	 * @param Objeto da classe EquipmentModelEntity
	 * @return Status code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentModelEntity> register(@RequestBody EquipmentModelEntity modelEntity) {

		EquipmentModelEntity modelEntitySaved = modelRepository.save(modelEntity);

		return new ResponseEntity<EquipmentModelEntity>(modelEntitySaved, HttpStatus.OK);
	}

	/**
	 * End point resposável pela atualização de um objeto da tabela EquipmentModelEntity no banco de dados
	 * @param Objeto da classe EquipmentModelEntity
	 * @return Status code 200 e  objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentModelEntity> edit(@RequestBody EquipmentModelEntity modelEntity) {

		EquipmentModelEntity modelEntityEdited = modelRepository.save(modelEntity);

		return new ResponseEntity<EquipmentModelEntity>(modelEntityEdited, HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção de um objeto da tabela EquipmentModelEntity no banco de dados
	 * @param modelo de equipamento ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeModel/{id}", produces = "application/text")
	public String modelDelete(@PathVariable(value = "id") UUID id) {

		modelRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point responsável pela busca de todos os objetos da tabela EquipmentModelEntity no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentModelEntity
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentModelDTO>> listAll() {
		List<EquipmentModelDTO> modelDTOs = new ArrayList<EquipmentModelDTO>();
		List<EquipmentModelEntity> allEquipmentModel = modelRepository.findAll();

		for (EquipmentModelEntity equipmentModelEntity : allEquipmentModel) {
			modelDTOs.add(new EquipmentModelDTO(equipmentModelEntity));
		}

		return new ResponseEntity<List<EquipmentModelDTO>>(modelDTOs, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um objeto na tabela EquipmentModelEntity no banco de dados
	 * @param modelo de equipamento ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentModelDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentModelEntity> modelEntity = modelRepository.findById(id);

		return new ResponseEntity<EquipmentModelDTO>(new EquipmentModelDTO(modelEntity.get()), HttpStatus.OK);
	}

}
