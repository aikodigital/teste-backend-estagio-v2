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

import br.com.DTO.EquipmentStateDTO;
import br.com.model.EquipmentStateEntity;
import br.com.repository.EquipmentStateRepository;

/**
 * Controller responsável pelos end points da classe EquipmentState
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/equipmentState")
public class EquipmentStateController {

	/**
	 * Injeção de dependência do repositório
	 */
	@Autowired
	private EquipmentStateRepository stateRepository;

	/**
	 * End point responsável pelo cadastramento de estados de equipamentos no banco de dados
	 * @param Objeto da classe EquipmentStateEntity
	 * @return Status code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentStateEntity> register(@RequestBody EquipmentStateEntity stateEntity) {

		EquipmentStateEntity stateEntitySaved = stateRepository.save(stateEntity);

		return new ResponseEntity<EquipmentStateEntity>(stateEntitySaved, HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção de um estado de equipamento no banco de dados
	 * @param estado de equipamento ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeState/{id}", produces = "application/text")
	public String stateDelete(@PathVariable(value = "id") UUID id) {

		stateRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point resposável pela atualização de um objeto da classe EquipmentStateEntity no banco de dados 
	 * @param objeto da classe EquipmentStateEntity
	 * @return Status code 200 e objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentStateEntity> edit(@RequestBody EquipmentStateEntity stateEntity) {

		EquipmentStateEntity stateEntityEdited = stateRepository.save(stateEntity);

		return new ResponseEntity<EquipmentStateEntity>(stateEntityEdited, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um estado de equipamento no banco de dados
	 * @param estado de equipamento id
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentStateDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentStateEntity> stateEntity = stateRepository.findById(id);

		return new ResponseEntity<EquipmentStateDTO>(new EquipmentStateDTO(stateEntity.get()), HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de todos os objetos contidos na tabela EquipmentStateEntity no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentStateEntity
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentStateDTO>> listAll() {
		List<EquipmentStateDTO> stateDTOs = new ArrayList<EquipmentStateDTO>();
		List<EquipmentStateEntity> allEquipmentState = stateRepository.findAll();

		for (EquipmentStateEntity equipmentStateEntity : allEquipmentState) {
			stateDTOs.add(new EquipmentStateDTO(equipmentStateEntity));
		}

		return new ResponseEntity<List<EquipmentStateDTO>>(stateDTOs, HttpStatus.OK);
	}

}
