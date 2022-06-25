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

public class EquipmentModelController {
	@Autowired
	EquipmentModelRepository equipmentMR;
	
	
	
	@GetMapping("/equipmentsmodel")
	 public ResponseEntity<List<EquipmentModel>> getAllEquipmentModel(@RequestParam(required = false) String name) {
		    try {
		      List<EquipmentModel> listaEquipmentsModel = new ArrayList<EquipmentModel>();
		      
		       
		     
		      if (name == null)
		    	  listaEquipmentsModel=(List<EquipmentModel>) equipmentMR.findAll();
		     
		        
		      if (listaEquipmentsModel.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(listaEquipmentsModel, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	 
	 @GetMapping("/equipmentsmodel/{id}")
	  public ResponseEntity<EquipmentModel> getEquipmentById(@PathVariable("id") UUID id) {
	    Optional<EquipmentModel> equipmentModelData = equipmentMR.findById(id);
	    if (equipmentModelData.isPresent()) {
	      return new ResponseEntity<>(equipmentModelData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/equipmentsmodel")
	  public ResponseEntity<EquipmentModel> createEquipmentModel(@RequestBody EquipmentModel equipM) {
	    try {
	      EquipmentModel _equipmentM = equipmentMR.save(new EquipmentModel(equipM.getId(),equipM.getName()));
	      return new ResponseEntity<>(_equipmentM, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/equipmentmodel/{id}")
		public ResponseEntity<EquipmentModel> updateEquipmentModel(@PathVariable("id") UUID id, @RequestBody EquipmentModel equipM) {
			Optional<EquipmentModel> equipmentMData = equipmentMR.findById(id);
			if (equipmentMData.isPresent()) {
				EquipmentModel _equipM = equipmentMData.get();
				_equipM.setName(equipM.getName());
				
				
				return new ResponseEntity<>(equipmentMR.save(_equipM), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@DeleteMapping("/equipmentmodel/{id}")
		public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") UUID id) {
			try {
				equipmentMR.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	 
	 
	 

}
