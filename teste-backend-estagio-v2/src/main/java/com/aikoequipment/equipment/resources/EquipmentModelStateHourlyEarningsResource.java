package com.aikoequipment.equipment.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aikoequipment.equipment.dtos.EquipmentModelStateHourlyEarningsDTO;
import com.aikoequipment.equipment.entities.EquipmentModelStateHourlyEarnings;
import com.aikoequipment.equipment.entities.PK.EquipmentModelStateHourlyEarningsPK;
import com.aikoequipment.equipment.services.EquipmentModelStateHourlyEarningsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/earnings")
public class EquipmentModelStateHourlyEarningsResource {

	@Autowired
	private EquipmentModelStateHourlyEarningsService service;

	@ApiOperation(value="Lista o valor por hora do modelo de equipamento")
	@GetMapping
 	public ResponseEntity<List<EquipmentModelStateHourlyEarningsDTO>> findAll() {
		List<EquipmentModelStateHourlyEarnings> list = service.findAll();
		List<EquipmentModelStateHourlyEarningsDTO> listDto = list.stream().map(x -> new EquipmentModelStateHourlyEarningsDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value="Lista o valor por hora do modelo de equipamento por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> findById(@PathVariable EquipmentModelStateHourlyEarningsPK id) {
		EquipmentModelStateHourlyEarningsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Cria o valor por hora do modelo de equipamento")
	@PostMapping
	public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> insert(
			@RequestBody EquipmentModelStateHourlyEarningsDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getEquipmentModelId(), dto.getEquipmentStateId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@ApiOperation(value="Atualiza o valor por hora do modelo de equipamento")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> update(@PathVariable EquipmentModelStateHourlyEarningsPK id,
			@RequestBody EquipmentModelStateHourlyEarningsDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value="Deleta o valor por hora do modelo de equipamento")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable EquipmentModelStateHourlyEarningsPK id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
