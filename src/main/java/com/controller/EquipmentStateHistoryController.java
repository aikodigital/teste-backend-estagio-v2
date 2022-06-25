package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.model.*;
import com.repository.*;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class EquipmentStateHistoryController {
	@Autowired
	EquipmentStateHistoryRepository equipmentSHR;
	
	
	
	@GetMapping("/equipmentsstatehistory")
	 public ResponseEntity<List<EquipmentStateHistory>> getAllEquipmentStateHistory() {
		    try {
		    
		      List<EquipmentStateHistory> listaEquipmentsSH = new ArrayList<EquipmentStateHistory>();
		      System.out.println("j");
		      listaEquipmentsSH= equipmentSHR.findAll();
		      System.out.println(listaEquipmentsSH);
		    
		       // equipmentR.findByName(name).forEach(listaEquipments::add);
		      if (listaEquipmentsSH.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipmentsSH, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	 
	 /*@GetMapping("/equipments/{id}")
	  public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") UUID id) {
	    Optional<Equipment> equipmentData = equipmentR.findById(id);
	    if (equipmentData.isPresent()) {
	      return new ResponseEntity<>(equipmentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/
	  @PostMapping("/equipmentsstatehistory")
	  public ResponseEntity<EquipmentStateHistory> createEquipmentStateHistory(@RequestBody EquipmentStateHistory equipSH) {
	    try {
	      EquipmentStateHistory _equipmentSH = equipmentSHR.save(new EquipmentStateHistory(equipSH.getId(),equipSH.getData()));
	      return new ResponseEntity<>(_equipmentSH, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	
}
