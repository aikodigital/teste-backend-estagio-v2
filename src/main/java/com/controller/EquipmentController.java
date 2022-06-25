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

public class EquipmentController {
	@Autowired
	EquipmentRepository equipmentR;
	
	
	
	@GetMapping("/equipments")
	 public ResponseEntity<List<Equipment>> getAllEquipment() {
		    try {
		    	
		      List<Equipment> listaEquipments = new ArrayList<Equipment>();
		      listaEquipments= equipmentR.findAll();
		      System.out.println(listaEquipments);
		    
		       // equipmentR.findByName(name).forEach(listaEquipments::add);
		      if (listaEquipments.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipments, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	 
	 @GetMapping("/equipments/{id}")
	  public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") UUID id) {
	    Optional<Equipment> equipmentData = equipmentR.findById(id);
	    if (equipmentData.isPresent()) {
	      return new ResponseEntity<>(equipmentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/equipments")
	  public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equip) {
	    try {
	      Equipment _equipment = equipmentR.save(new Equipment(equip.getId(),equip.getName(), equip.getModel_equipment()));
	      return new ResponseEntity<>(_equipment, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/equipment/{id}")
		public ResponseEntity<Equipment> updateEquipment(@PathVariable("id") UUID id, @RequestBody Equipment equip) {
			Optional<Equipment> equipmentData = equipmentR.findById(id);
			if (equipmentData.isPresent()) {
				Equipment _equip = equipmentData.get();
				_equip.setName(equip.getName());
				_equip.setModel_equipment(equip.getModel_equipment());
				
				return new ResponseEntity<>(equipmentR.save(_equip), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@DeleteMapping("/equipment/{id}")
		public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") UUID id) {
			try {
				equipmentR.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	 
	 
	 
	
	
		
	

}
