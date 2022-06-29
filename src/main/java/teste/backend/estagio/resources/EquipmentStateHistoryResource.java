package teste.backend.estagio.resources;

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

import io.swagger.annotations.ApiOperation;
import teste.backend.estagio.entities.EquipmentStateHistory;
import teste.backend.estagio.services.EquipmentStateHistoryService;

@RestController
@RequestMapping(value = "/api")
public class EquipmentStateHistoryResource {

	@Autowired
	private EquipmentStateHistoryService equipmentStateHistoryService;
	
	@GetMapping("/statehistory")
	@ApiOperation(value = "Retorna um histórico de estado de todos os equipamentos do banco")
	public ResponseEntity<List<EquipmentStateHistory>> findAll(){
		List<EquipmentStateHistory> list = equipmentStateHistoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/statehistory/{id_equipment}/{id_state}")
	@ApiOperation(value = "Retorna um histórico de estado de um determinado equipamento de acordo com o ID passado")
	public ResponseEntity<EquipmentStateHistory> findById(@PathVariable UUID id_equipment,@PathVariable UUID id_state){
		EquipmentStateHistory stateHistory = equipmentStateHistoryService.findById(id_equipment,id_state);
		return ResponseEntity.ok().body(stateHistory);
	}
	
	@PostMapping("/statehistory")
	@ApiOperation(value = "Registra um novo histórico de estado um equipamento no banco")
	public ResponseEntity<EquipmentStateHistory> insert(@RequestBody EquipmentStateHistory stateHistory){
		stateHistory = equipmentStateHistoryService.insert(stateHistory);
		return ResponseEntity.ok().body(stateHistory);
	}
	
	@PutMapping("/statehistory/{id_equipment}/{id_state}")
	@ApiOperation(value = "Altera o histórico de determinado equipamento de acordo com o ID passado")
	public ResponseEntity<EquipmentStateHistory> update(@PathVariable UUID id_equipment,@PathVariable UUID id_state,@RequestBody EquipmentStateHistory stateHistory){
		stateHistory = equipmentStateHistoryService.update(id_equipment,id_state,stateHistory);
		return ResponseEntity.ok().body(stateHistory);
	}
	
	@DeleteMapping("/statehistory/{id_equipment}/{id_state}")
	@ApiOperation(value = "Deleta o histórico de determinado equipamento de acordo com o ID passado")
	public ResponseEntity<Void> deleteStateHistory(@PathVariable UUID id_equipment,@PathVariable UUID id_state){
		equipmentStateHistoryService.delete(id_equipment,id_state);
		return ResponseEntity.noContent().build();
	}
}
