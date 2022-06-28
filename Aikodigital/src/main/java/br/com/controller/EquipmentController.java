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

import br.com.DTO.EquipmentDTO;
import br.com.model.EquipmentEntity;
import br.com.repository.EquipmentRepository;

/**
 * Controller responsável pelos end points da classe Equipment
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/equipment")
public class EquipmentController {

	/**
	 * Injeção de dependência do repositório
	 */
	@Autowired
	private EquipmentRepository equipmentRepository;

	/**
	 * End point responsável pelo cadastramento do equipamento no banco de dados
	 * @param Objeto da classe EquipmentEntity
	 * @return Status code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentEntity> register(@RequestBody EquipmentEntity equipmentEntity) {

		EquipmentEntity equipmentEntitySaved = equipmentRepository.save(equipmentEntity);

		return new ResponseEntity<EquipmentEntity>(equipmentEntitySaved, HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção do equipamento no banco de dados
	 * @param equipamento ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeEquipment/{id}", produces = "application/text")
	public String equipmentDelete(@PathVariable(value = "id") UUID id) {

		equipmentRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point resposável pela atualização de um objeto da classe EquipmentEntity no banco de dados 
	 * @param objeto da classe EquipmentEntity
	 * @return Status code 200 e objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentEntity> edit(@RequestBody EquipmentEntity equipmentEntity) {

		EquipmentEntity equipmentEntityEdited = equipmentRepository.save(equipmentEntity);

		return new ResponseEntity<EquipmentEntity>(equipmentEntityEdited, HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um equipamento no banco de dados
	 * @param equipamento id
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentEntity> equipmentEntity = equipmentRepository.findById(id);

		return new ResponseEntity<EquipmentDTO>(new EquipmentDTO(equipmentEntity.get()), HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de todos os objetos contidos na tabela EquipmentEntity no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentEntity
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentDTO>> listAll() {
		List<EquipmentDTO> equipmentDTOs = new ArrayList<EquipmentDTO>();
		List<EquipmentEntity> allEquipment = equipmentRepository.findAll();

		for (EquipmentEntity equipmentEntity : allEquipment) {
			equipmentDTOs.add(new EquipmentDTO(equipmentEntity));
		}

		return new ResponseEntity<List<EquipmentDTO>>(equipmentDTOs, HttpStatus.OK);
	}

}
