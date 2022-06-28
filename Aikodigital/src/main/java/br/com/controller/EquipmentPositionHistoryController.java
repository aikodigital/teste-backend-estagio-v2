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

import br.com.DTO.EquipmentPositionHistoryDTO;
import br.com.model.EquipmentEntity;
import br.com.model.EquipmentPositionHistoryEntity;
import br.com.repository.EquipmentPositionHistoryRepository;
import br.com.repository.EquipmentRepository;

/**
 * Controller responsável pelos end points da classe EquipmentPositionHistory
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/equipmentPositionHistory")
public class EquipmentPositionHistoryController {

	/**
	 * Injeção de dependência do repositório da classe EquipmentPositionHistory
	 */
	@Autowired
	private EquipmentPositionHistoryRepository positionHistoryRepository;

	/**
	 * Injeção de dependência do repositório da classe Equipment
	 */
	@Autowired
	private EquipmentRepository equipmentRepository;

	/**
	 * End point responsável pelo cadastro do histórico de posições de equipamentos no banco de dados
	 * @param Objeto da classe EquipmentPositionHistoryEntity
	 * @return Status code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentPositionHistoryEntity> register(
			@RequestBody EquipmentPositionHistoryEntity positionHistoryEntity) {

		EquipmentPositionHistoryEntity positionHistoryEntitySaved = positionHistoryRepository
				.save(positionHistoryEntity);

		return new ResponseEntity<EquipmentPositionHistoryEntity>(positionHistoryEntitySaved, HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção de um histórico de posição de um equipamento no banco de dados
	 * @param posição equipamento ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeEquipmentPositionHistory/{id}", produces = "application/text")
	public String equipmentPositionHistoryDelete(@PathVariable(value = "id") UUID id) {

		positionHistoryRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point resposável pela atualização de um objeto da classe EquipmentPositionHistoryEntity no banco de dados 
	 * @param objeto da classe EquipmentPositionHistoryEntity
	 * @return Status code 200 e objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentPositionHistoryEntity> edit(
			@RequestBody EquipmentPositionHistoryEntity positionHistoryEntity) {

		EquipmentPositionHistoryEntity positionHistoryEntityEdited = positionHistoryRepository
				.save(positionHistoryEntity);

		return new ResponseEntity<EquipmentPositionHistoryEntity>(positionHistoryEntityEdited, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um histórico de posição de um equipamento no banco de dados
	 * @param posição equipamento ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentPositionHistoryDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentPositionHistoryEntity> equipmentpositionHistoryEntity = positionHistoryRepository
				.findById(id);

		return new ResponseEntity<EquipmentPositionHistoryDTO>(
				new EquipmentPositionHistoryDTO(equipmentpositionHistoryEntity.get()), HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de todos os objetos contidos na tabela EquipmentPositionHistoryEntity no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentPositionHistoryEntity
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentPositionHistoryDTO>> listAll() {
		List<EquipmentPositionHistoryDTO> equipmentPositionHistoryDTOs = new ArrayList<EquipmentPositionHistoryDTO>();
		List<EquipmentPositionHistoryEntity> allEquipmentPositionHistory = positionHistoryRepository.findAll();

		for (EquipmentPositionHistoryEntity equipmentPositionHistoryEntity : allEquipmentPositionHistory) {
			equipmentPositionHistoryDTOs.add(new EquipmentPositionHistoryDTO(equipmentPositionHistoryEntity));
		}

		return new ResponseEntity<List<EquipmentPositionHistoryDTO>>(equipmentPositionHistoryDTOs, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca dos históricos de posições mais recentes por equipamento
	 * @return Status code 200 e lista de posições por equipamento mais recentes
	 */
	@GetMapping(value = "/v1/mostRecentlyPosition", produces = "application/json")
	public ResponseEntity<List<EquipmentPositionHistoryDTO>> listMostRecentlyPosition() {
		List<EquipmentPositionHistoryDTO> equipmentPositionHistoryDTOs = new ArrayList<EquipmentPositionHistoryDTO>();
		List<EquipmentPositionHistoryEntity> allEquipmentPositionHistory = new ArrayList<EquipmentPositionHistoryEntity>();
		List<EquipmentEntity> equipmentEntities = equipmentRepository.findAll();

		for (EquipmentEntity equipmentEntity : equipmentEntities) {
			allEquipmentPositionHistory.add(positionHistoryRepository.mostRecentlyPosition(equipmentEntity.getId()));
		}

		for (EquipmentPositionHistoryEntity equipmentStateHistoryEntity : allEquipmentPositionHistory) {
			equipmentPositionHistoryDTOs.add(new EquipmentPositionHistoryDTO(equipmentStateHistoryEntity));
		}

		return new ResponseEntity<List<EquipmentPositionHistoryDTO>>(equipmentPositionHistoryDTOs, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um histórico de posição mais recente de um equipamento 
	 * @param equipamento ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/v2/mostRecentlyPosition/{id}", produces = "application/json")
	public ResponseEntity<EquipmentPositionHistoryDTO> listMostRecentlyPositionWithId(
			@PathVariable(value = "id") UUID id) {

		EquipmentPositionHistoryEntity positionHistoryEntity = positionHistoryRepository.mostRecentlyPosition(id);

		return new ResponseEntity<EquipmentPositionHistoryDTO>(new EquipmentPositionHistoryDTO(positionHistoryEntity),
				HttpStatus.OK);
	}
}
