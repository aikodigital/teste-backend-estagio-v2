package teste.backend.estagio.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

import io.swagger.annotations.ApiOperation;
import teste.backend.estagio.entities.EquipmentModelStateHourlyEarnings;
import teste.backend.estagio.services.EquipmentModelStateHourlyEarningsService;

@RestController
@RequestMapping(value = "/api")
public class EquipmentModelStateHourlyEarningsResource {

	@Autowired
	private EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService; 
	
	@GetMapping("/earnings")
	@ApiOperation(value = "Retorna todos os registros de ganhos por hora de acordo com o estado dos de equipamentos")
	public ResponseEntity<List<EquipmentModelStateHourlyEarnings>> findAll(){
		List<EquipmentModelStateHourlyEarnings> list = equipmentModelStateHourlyEarningsService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/earnings/{id_model}/{id_state}")
	@ApiOperation(value = "Retorna um único registro de ganhos por hora de acordo com o estado dos de equipamentos de acordo com o ID passado")
	public ResponseEntity<EquipmentModelStateHourlyEarnings> findById(@PathVariable UUID id_model,@PathVariable UUID id_state){
		EquipmentModelStateHourlyEarnings hourlyEarnings = equipmentModelStateHourlyEarningsService.findById(id_model,id_state);
		return ResponseEntity.ok().body(hourlyEarnings);
	}
	
	@PostMapping("/earnings")
	@ApiOperation(value = "Registra um novo ganho por hora de um equipamento de um determinado estado")
	public ResponseEntity<EquipmentModelStateHourlyEarnings> insert(@RequestBody EquipmentModelStateHourlyEarnings hourlyEarnings){
		hourlyEarnings = equipmentModelStateHourlyEarningsService.insert(hourlyEarnings);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hourlyEarnings.getValue()).toUri();
		return ResponseEntity.created(uri).body(hourlyEarnings);
	}
	
	@PutMapping("/earnings/{id_model}/{id_state}")
	@ApiOperation(value = "Altera um determinado ganho por hora de um equipamento em um estado de acordo com o ID passado")
	public ResponseEntity<EquipmentModelStateHourlyEarnings> update(@PathVariable UUID id_model,@PathVariable UUID id_state,@RequestBody EquipmentModelStateHourlyEarnings hourlyEarnings){
		hourlyEarnings = equipmentModelStateHourlyEarningsService.update(id_model,id_state, hourlyEarnings);
		return ResponseEntity.ok().body(hourlyEarnings);
	}
	
	@DeleteMapping("/earnings/{id_model}/{id_state}")
	@ApiOperation(value = "Delta um registro de ganho de acordo com o ID passado")
	public ResponseEntity<Void> deleteStateHistory(@PathVariable UUID id_model,@PathVariable UUID id_state){
		equipmentModelStateHourlyEarningsService.delete(id_model,id_state);
		return ResponseEntity.noContent().build();
	}
}