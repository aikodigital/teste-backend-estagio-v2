package io.github.humbertoluiz.rest.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertoluiz.domain.entity.EquipmentModel;
import io.github.humbertoluiz.dto.EquipmentModelDTO;
import io.github.humbertoluiz.service.EquipmentModelService;

@RestController
@RequestMapping("/api/v1/equipmentmodels")
public class EquipmentModelController {

	@Autowired
	private EquipmentModelService equipmentModelService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipmentModel save(@RequestBody @Valid EquipmentModelDTO equipmentModelDTO) {
		EquipmentModel equipmentModel = equipmentModelService.save(equipmentModelDTO);
		return equipmentModel;
	}	
	
	@GetMapping("/{equipmentModelId}")
	public Optional<EquipmentModel> getById(@PathVariable UUID equipmentModelId) {
		return equipmentModelService.getById(equipmentModelId);
	}
		
	@DeleteMapping("/{equipmentModelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable UUID equipmentModelId ) {
		equipmentModelService.delete(equipmentModelId);
	}

	@PutMapping("/{equipmentModelId}")
	public void update(@PathVariable UUID equipmentModelId) {
		equipmentModelService.update(equipmentModelId);
	}

	@GetMapping
	public List<EquipmentModel> getByFilter(EquipmentModel filter) {		
		return equipmentModelService.getByFilter(filter);
	}

}
