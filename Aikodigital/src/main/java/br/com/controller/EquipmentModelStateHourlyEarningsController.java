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

import br.com.DTO.EquipmentModelStateHourlyEarningsDTO;
import br.com.model.EquipmentModelStateHourlyEarningsEntity;
import br.com.repository.EquipmentModelStateHourlyEarningsRepository;

/**
 * Controller responsável pelos end points da classe EquipmentModelStateHourlyEarnings
 * @author Danillo Santiago
 * @since jun 2022
 */
@RestController
@RequestMapping(value = "/EquipmentModelStateHourlyEarnings")
public class EquipmentModelStateHourlyEarningsController {

	/**
	 * Injeção de dependência do repositório
	 */
	@Autowired
	private EquipmentModelStateHourlyEarningsRepository stateHourlyEarningsRepository;

	/**
	 * End point responsável pelo cadastro de um objeto no banco de dados
	 * @param Objeto da classe EquipmentModelStateHourlyEarningsEntity
	 * @return Satus code 200 e objeto cadastrado
	 */
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<EquipmentModelStateHourlyEarningsEntity> register(
			@RequestBody EquipmentModelStateHourlyEarningsEntity stateHourlyEarningsEntity) {

		EquipmentModelStateHourlyEarningsEntity modelStateHourlyEarningsEntity = stateHourlyEarningsRepository
				.save(stateHourlyEarningsEntity);

		return new ResponseEntity<EquipmentModelStateHourlyEarningsEntity>(modelStateHourlyEarningsEntity,
				HttpStatus.OK);
	}

	/**
	 * End point responsável pela remoção do objeto cadastrado na tabela EquipmentModelStateHourlyEarningsEntity no banco de dados
	 * @param valor por hora do modelo de equipamento em cada estado ID
	 * @return mensagem : Successfully removed!
	 */
	@DeleteMapping(value = "removeEquipmentPositionHistory/{id}", produces = "application/text")
	public String equipmentModelStateHourlyEarningsDelete(@PathVariable(value = "id") UUID id) {

		stateHourlyEarningsRepository.deleteById(id);

		return "Successfully removed!";
	}

	/**
	 * End point resposável pela atualização de um objeto da classe EquipmentModelStateHourlyEarningsEntity no banco de dados 
	 * @param Objeto da classe EquipmentModelStateHourlyEarningsEntity
	 * @return Status code 200 e objeto atualizado
	 */
	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<EquipmentModelStateHourlyEarningsEntity> edit(
			@RequestBody EquipmentModelStateHourlyEarningsEntity stateHourlyEarningsEntity) {

		EquipmentModelStateHourlyEarningsEntity modelStateHourlyEarningsEntityEdited = stateHourlyEarningsRepository
				.save(stateHourlyEarningsEntity);

		return new ResponseEntity<EquipmentModelStateHourlyEarningsEntity>(modelStateHourlyEarningsEntityEdited,
				HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de um objeto da tabela EquipmentModelStateHourlyEarnings no banco de dados
	 * @param  valor por hora do modelo de equipamento em cada estado ID
	 * @return Status code 200 e objeto encontrado
	 */
	@GetMapping(value = "/listOne/{id}", produces = "application/json")
	public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> listOne(@PathVariable(value = "id") UUID id) {

		Optional<EquipmentModelStateHourlyEarningsEntity> modelStateEarningsEntity = stateHourlyEarningsRepository
				.findById(id);

		return new ResponseEntity<EquipmentModelStateHourlyEarningsDTO>(
				new EquipmentModelStateHourlyEarningsDTO(modelStateEarningsEntity.get()), HttpStatus.OK);
	}

	/**
	 * End point responsável pela busca de todos os objetos contidos na tabela EquipmentModelStateHourlyEarnings no banco de dados
	 * @return Status code 200 e lista de objetos da classe EquipmentModelStateHourlyEarnings
	 */
	@GetMapping(value = "/listAll", produces = "application/json")
	public ResponseEntity<List<EquipmentModelStateHourlyEarningsDTO>> listAll() {
		List<EquipmentModelStateHourlyEarningsDTO> stateHourlyEarningsDTOs = new ArrayList<EquipmentModelStateHourlyEarningsDTO>();
		List<EquipmentModelStateHourlyEarningsEntity> hourlyEarningsEntities = stateHourlyEarningsRepository.findAll();

		for (EquipmentModelStateHourlyEarningsEntity hourlyEarningsEntity : hourlyEarningsEntities) {
			stateHourlyEarningsDTOs.add(new EquipmentModelStateHourlyEarningsDTO(hourlyEarningsEntity));
		}

		return new ResponseEntity<List<EquipmentModelStateHourlyEarningsDTO>>(stateHourlyEarningsDTOs, HttpStatus.OK);
	}
}
