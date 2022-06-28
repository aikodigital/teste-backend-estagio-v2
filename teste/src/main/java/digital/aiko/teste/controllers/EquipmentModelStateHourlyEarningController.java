package digital.aiko.teste.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import digital.aiko.teste.model.entities.EquipmentModelStateHourlyEarnings;
import digital.aiko.teste.model.services.EquipmentModelStateHourlyEarningServices;

@RestController
@RequestMapping(path = "/equipment-model-state-hourly-earning")
public class EquipmentModelStateHourlyEarningController {

	private EquipmentModelStateHourlyEarningServices service;
	
	
	
	public EquipmentModelStateHourlyEarningController(EquipmentModelStateHourlyEarningServices service) {
		this.service = service;
	}


	@PostMapping
	public @ResponseBody EquipmentModelStateHourlyEarnings save(@RequestBody EquipmentModelStateHourlyEarnings equipmentPositionHistory) {
		return this.service.save(equipmentPositionHistory);
		
	} 

	
	@GetMapping
	public ResponseEntity<Iterable<EquipmentModelStateHourlyEarnings>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

}

