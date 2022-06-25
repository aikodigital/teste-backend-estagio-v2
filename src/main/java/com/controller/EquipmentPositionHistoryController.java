package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.EquipmentPositionHistory;
import com.repository.EquipmentPositionHistoryRepository;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class EquipmentPositionHistoryController {
	  @Autowired
	  EquipmentPositionHistoryRepository equipmentPHR;
	
	
	
	@GetMapping("/equipmentspositionhistory")
	 public ResponseEntity<List<EquipmentPositionHistory>> getAllEquipmentPositionHistory() {
		    try {
	    		System.out.println("try");
			    List<EquipmentPositionHistory> listaEquipmentsPH = new ArrayList<EquipmentPositionHistory>();
			    System.out.println(listaEquipmentsPH);
			    listaEquipmentsPH= equipmentPHR.findAll();
			    System.out.println(listaEquipmentsPH);
		    
		       // equipmentR.findByName(name).forEach(listaEquipments::add);
		      if (listaEquipmentsPH.isEmpty()) {
		    	  System.out.println("vazia?");
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipmentsPH, HttpStatus.OK);
		    } catch (Exception e) {
		    	System.out.println(e);
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	 
	/* @GetMapping("/equipments/{id}")
	  public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") UUID id) {
	    Optional<Equipment> equipmentData = equipmentR.findById(id);
	    if (equipmentData.isPresent()) {
	      return new ResponseEntity<>(equipmentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/
	  @PostMapping("/equipmentspositionhistory")
	  public ResponseEntity<EquipmentPositionHistory> createEquipmentPositionHistory(@RequestBody EquipmentPositionHistory equipPH) {
	    try {
	      EquipmentPositionHistory _equipmentPH = equipmentPHR.save(new EquipmentPositionHistory(equipPH.getPositionhistoryid(),equipPH.getDate()));
	      return new ResponseEntity<>(_equipmentPH, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
}
