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
import teste.backend.estagio.entities.EquipmentPositionHistory;
import teste.backend.estagio.services.EquipmentPositionHistoryService;

@RestController
@RequestMapping(value = "/api")
public class EquipmentPositionHistoryResource {
	
	@Autowired
	private EquipmentPositionHistoryService equipmentPositionHistoryService;
	
	@GetMapping("/position")
	@ApiOperation(value = "Retorna um histórico de posições de todos os equipamentos do banco")
	public ResponseEntity<List<EquipmentPositionHistory>> findAll(){
		List<EquipmentPositionHistory> list = equipmentPositionHistoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/position/{id_equipment}")
	@ApiOperation(value = "Retorna um histórico de posições de um determinado equipamento de acordo com o ID passado")
	public ResponseEntity<EquipmentPositionHistory> findById(@PathVariable UUID id_equipment){
		EquipmentPositionHistory position = equipmentPositionHistoryService.findById(id_equipment);
		return ResponseEntity.ok().body(position);
	}
	
	@GetMapping("/position/{id_equipment}")
	@ApiOperation(value = "Retorna a posição atual de um determinado equipamento de acordo com o ID passado")
	public ResponseEntity <List<EquipmentPositionHistory>> currentEquipmentPosition(@PathVariable UUID id_equipment){
		List<EquipmentPositionHistory> position = equipmentPositionHistoryService.currentEquipmentPosition(id_equipment);
		return ResponseEntity.ok().body(position);
	}
	@PostMapping("/position")
	@ApiOperation(value = "Registra um no banco um novo histórico de posições de um equipamento")
	public ResponseEntity<EquipmentPositionHistory> insert(@RequestBody EquipmentPositionHistory positionHistory){
		positionHistory = equipmentPositionHistoryService.insert(positionHistory);
		return ResponseEntity.ok().body(positionHistory);
	}
	
	@PutMapping("/position/{id_equipment}")
	@ApiOperation(value = "Altera o histórico de posições de determinado equipamento de acordo com o ID passado")
	public ResponseEntity<EquipmentPositionHistory> update(@PathVariable UUID id_equipment, @RequestBody EquipmentPositionHistory positionHistory){
		positionHistory = equipmentPositionHistoryService.update(id_equipment, positionHistory);
		return ResponseEntity.ok().body(positionHistory);
	}
	
	@DeleteMapping("/position{id_equipment}")
	@ApiOperation(value = "Deleta do banco um determinado histórico de posições de acordo com o ID passado")
	public ResponseEntity<Void> deleteState(@PathVariable UUID id_equipment){
		equipmentPositionHistoryService.delete(id_equipment);
		return ResponseEntity.noContent().build();
	}


}
