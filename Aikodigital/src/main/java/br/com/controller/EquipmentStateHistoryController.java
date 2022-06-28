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

import br.com.DTO.EquipmentStateHistoryDTO;
import br.com.model.EquipmentEntity;
import br.com.model.EquipmentStateHistoryEntity;
import br.com.repository.EquipmentRepository;
import br.com.repository.EquipmentStateHistoryRepository;

/**
 * Controller responsável pelos end points da classe EquipmentStateHistory
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/equipmentStateHistory")
public class EquipmentStateHistoryController {

	/**
	 * Injeção de dependência do repositório da classe EquipmentStateHistory
	 */
	@Autowired
	private EquipmentStateHistoryRepository stateHistoryRepository;

	/**
	 * Injeção de dependência do repositório da classe Equipment
	 */
	@Autowired
	private EquipmentRepository equipmentRepository;

	/**
	 * End point responsável pelo cadastro do histórico de estados de equipamentos no banco de dados
	 * @param Objeto da classe EquipmentStateHistoryEntity
	 * @return Status code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentStateHistoryEntity> register(
			@RequestBody EquipmentStateHistoryEntity stateHistoryEntity) {

		EquipmentStateHistoryEntity stateHistoryEntitySaved = stateHistoryRepository.save(stateHistoryEntity);

		return new ResponseEntity<EquipmentStateHistoryEntity>(stateHistoryEntitySaved, HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção de um histórico de estado de um equipamento no banco de dados
	 * @param histórico estado equipamento ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeEquipmentStateHistory/{id}", produces = "application/text")
	public String equipmentStateHistoryDelete(@PathVariable(value = "id") UUID id) {

		stateHistoryRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point resposável pela atualização de um objeto da classe EquipmentStateHistoryEntity no banco de dados 
	 * @param objeto da classe EquipmentStateHistoryEntity
	 * @return Status code 200 e objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentStateHistoryEntity> edit(
			@RequestBody EquipmentStateHistoryEntity stateHistoryEntity) {

		EquipmentStateHistoryEntity equipmentStateHistoryEntityEdited = stateHistoryRepository.save(stateHistoryEntity);

		return new ResponseEntity<EquipmentStateHistoryEntity>(equipmentStateHistoryEntityEdited, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um histórico de estado de um equipamento no banco de dados
	 * @param histórico de estado equipamento ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentStateHistoryDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentStateHistoryEntity> equipmentStateHistoryEntity = stateHistoryRepository.findById(id);

		return new ResponseEntity<EquipmentStateHistoryDTO>(
				new EquipmentStateHistoryDTO(equipmentStateHistoryEntity.get()), HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de todos os objetos contidos na tabela EquipmentStateHistoryEntity no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentStateHistoryEntity
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentStateHistoryDTO>> listAll() {
		List<EquipmentStateHistoryDTO> equipmentStateHistoryDTOs = new ArrayList<EquipmentStateHistoryDTO>();
		List<EquipmentStateHistoryEntity> allEquipmentStateHistory = stateHistoryRepository.findAll();

		for (EquipmentStateHistoryEntity equipmentStateHistoryEntity : allEquipmentStateHistory) {
			equipmentStateHistoryDTOs.add(new EquipmentStateHistoryDTO(equipmentStateHistoryEntity));
		}

		return new ResponseEntity<List<EquipmentStateHistoryDTO>>(equipmentStateHistoryDTOs, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca do histórico de estado mais recentes por equipamento
	 * @return Status code 200 e lista de posições por equipamento mais recentes
	 */
	@GetMapping(value = "/v1/mostRecentlyState", produces = "application/json")
	public ResponseEntity<List<EquipmentStateHistoryDTO>> listMostRecentlyState() {
		List<EquipmentStateHistoryDTO> equipmentStateHistoryDTOs = new ArrayList<EquipmentStateHistoryDTO>();
		List<EquipmentStateHistoryEntity> allEquipmentStateHistory = new ArrayList<EquipmentStateHistoryEntity>();
		List<EquipmentEntity> equipmentEntities = equipmentRepository.findAll();

		for (EquipmentEntity equipmentEntity : equipmentEntities) {
			allEquipmentStateHistory.add(stateHistoryRepository.mostRecentlyState(equipmentEntity.getId()));
		}

		for (EquipmentStateHistoryEntity equipmentStateHistoryEntity : allEquipmentStateHistory) {
			equipmentStateHistoryDTOs.add(new EquipmentStateHistoryDTO(equipmentStateHistoryEntity));
		}

		return new ResponseEntity<List<EquipmentStateHistoryDTO>>(equipmentStateHistoryDTOs, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de histórico de estado mais recente de um equipamento 
	 * @param equipamento ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/v2/mostRecentlyState/{id}", produces = "application/json")
	public ResponseEntity<EquipmentStateHistoryDTO> listMostRecentlyStateWithId(@PathVariable(value = "id") UUID id) {

		EquipmentStateHistoryEntity stateHistoryEntity = stateHistoryRepository.mostRecentlyState(id);

		return new ResponseEntity<EquipmentStateHistoryDTO>(new EquipmentStateHistoryDTO(stateHistoryEntity),
				HttpStatus.OK);
	}

}
