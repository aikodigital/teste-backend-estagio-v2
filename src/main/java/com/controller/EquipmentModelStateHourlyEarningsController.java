package com.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.model.*;
import com.repository.*;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EquipmentModelStateHourlyEarningsController {
	@Autowired
	EquipmentModelStateHourlyEarningsRepository equipmentMSHER;
	
	
	
	@GetMapping("/equipmentsmodelstategourlyearnings")
	 public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> getAllEquipmentModelStateHourlyEarnings() {
		    try {
		    	
		      List<EquipmentModelStateHourlyEarnings> listaEquipmentsMSHE = new ArrayList<EquipmentModelStateHourlyEarnings>();
		      listaEquipmentsMSHE= equipmentMSHER.findAll();
		      System.out.println(listaEquipmentsMSHE);
		    
		       // equipmentR.findByName(name).forEach(listaEquipments::add);
		      if (listaEquipmentsMSHE.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipmentsMSHE, HttpStatus.OK);
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
	  @PostMapping("/equipmentsmodelstategourlyearnings")
	  public ResponseEntity<EquipmentModelStateHourlyEarnings> createEquipmentModelStateHourlyEarnings(@RequestBody EquipmentModelStateHourlyEarnings equipMSHE) {
	    try {
	      EquipmentModelStateHourlyEarnings _equipmentMSHE = equipmentMSHER.save(new EquipmentModelStateHourlyEarnings(equipMSHE.getMsheid()));
	      return new ResponseEntity<>(_equipmentMSHE, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	 

}
