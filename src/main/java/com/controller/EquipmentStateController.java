package com.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Equipment;
import com.model.EquipmentState;
import com.repository.EquipmentStateRepository;
@RestController
@RequestMapping("/api")
public class EquipmentStateController {
	
	@Autowired
	EquipmentStateRepository equipmentSR;
	
	
	
	@GetMapping("/equipmentsstate")
	 public ResponseEntity<List<EquipmentState>> getAllEquipmentState(@RequestParam(required = false) String name) {
		    try {
		      List<EquipmentState> listaEquipmentsState = new ArrayList<EquipmentState>();
		      if (name == null)
		        equipmentSR.findAll().forEach(listaEquipmentsState::add);
		      else
		        equipmentSR.findByName(name).forEach(listaEquipmentsState::add);
		      if (listaEquipmentsState.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipmentsState, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	 
	 @GetMapping("/equipmentsstate/{id}")
	  public ResponseEntity<EquipmentState> getEquipmentById(@PathVariable("id") UUID id) {
	    Optional<EquipmentState> equipmentData = equipmentSR.findById(id);
	    if (equipmentData.isPresent()) {
	      return new ResponseEntity<>(equipmentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/equipmentsstate")
	  public ResponseEntity<EquipmentState> createEquipment(@RequestBody EquipmentState equipS) {
	    try {
	      EquipmentState _equipmentS = equipmentSR.save(new EquipmentState(equipS.getId(),equipS.getName(), equipS.getColor()));
	      return new ResponseEntity<>(_equipmentS, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @PutMapping("/equipmentstate/{id}")
		public ResponseEntity<EquipmentState> updateEquipmentState(@PathVariable("id") UUID id, @RequestBody EquipmentState equipS) {
			Optional<EquipmentState> equipmentSData = equipmentSR.findById(id);
			if (equipmentSData.isPresent()) {
				EquipmentState _equipS = equipmentSData.get();
				_equipS.setName(equipS.getName());
				_equipS.setColor(equipS.getColor());
				
				return new ResponseEntity<>(equipmentSR.save(_equipS), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@DeleteMapping("/equipmentstate/{id}")
		public ResponseEntity<HttpStatus> deleteEquipmentState(@PathVariable("id") UUID id) {
			try {
				equipmentSR.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	 

}
