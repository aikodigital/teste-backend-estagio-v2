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
import teste.backend.estagio.entities.EquipmentState;
import teste.backend.estagio.services.EquipmentStateService;

@RestController
@RequestMapping(value = "/api")
public class EquipmentStateResource {
	
	@Autowired
	private EquipmentStateService equipmentStateService;
	
	@GetMapping("/state")
	@ApiOperation(value = "Retorna o estado de todos os equipamentos registrados no banco")
	public ResponseEntity<List<EquipmentState>> findAll(){
		List<EquipmentState> list = equipmentStateService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/state/{id}")
	@ApiOperation(value = "Retorna o estado de apenas um determinado equipamento de acordo com o ID passado")
	public ResponseEntity <EquipmentState> findById(@PathVariable (value = "id") UUID id){
		EquipmentState state = equipmentStateService.findById(id);
		return ResponseEntity.ok().body(state);
	}
	
	@PostMapping("/state")
	@ApiOperation(value = "Registra um novo estado de um equipamento")
	public ResponseEntity<EquipmentState> insert(@RequestBody EquipmentState state){
		state = equipmentStateService.insert(state);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(state);
	}
	
	@PutMapping("/state/{id}")
	@ApiOperation(value = "Altera o estado de um determinado equipamento de acordo com o ID passado")
	public ResponseEntity<EquipmentState> update(@PathVariable UUID id, @RequestBody EquipmentState state){
		state = equipmentStateService.update(id,state);
		return ResponseEntity.ok().body(state);
	}
	
	@DeleteMapping("/state/{id}")
	@ApiOperation(value = "Deleta um estado de um determinado equipamento de acordo com o ID passado")
	public ResponseEntity<Void> deleteState(@PathVariable (value = "id") UUID id){
		equipmentStateService.delete(id);
		return ResponseEntity.noContent().build();
	}


}
