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
import teste.backend.estagio.entities.EquipmentModel;
import teste.backend.estagio.services.EquipmentModelService;

@RestController
@RequestMapping(value="/api")
public class EquipmentModelResource {
	
	@Autowired
	private EquipmentModelService equipmentModelService;
	
	@GetMapping(value = "/models")
	@ApiOperation(value = "Retorna todos os registros de modelos de equipamentos do banco")
	public ResponseEntity<List<EquipmentModel>> findAll(){
		List<EquipmentModel> list = equipmentModelService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/models/{id}")
	@ApiOperation(value = "Retorna apenas um registro de modelo de equipamento correspondente ao ID passado")
	public ResponseEntity <EquipmentModel> findById(@PathVariable UUID id){
		EquipmentModel obj = equipmentModelService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/models")
	@ApiOperation(value = "Registra um novo modelo de equipamento no banco")
	public ResponseEntity<EquipmentModel> insert(@RequestBody EquipmentModel equipmentModel) {
		equipmentModel = equipmentModelService.insert(equipmentModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentModel.getId()).toUri();
		return ResponseEntity.created(uri).body(equipmentModel);
	}

	@PutMapping("/models/{id}")
	@ApiOperation(value = "Altera um registro de modelo de equipamento do banco de acordo com ID passado")
	public ResponseEntity<EquipmentModel> update(@PathVariable UUID id, @RequestBody EquipmentModel equipmentModel){
		equipmentModel = equipmentModelService.update(id,equipmentModel);
		return ResponseEntity.ok().body(equipmentModel);
	}

	@DeleteMapping("/models/{id}")
	@ApiOperation(value = "Deleta do banco um determinado modelo de equipamento de acordo com o ID passado")
	public ResponseEntity<Void> deleteEquipment(@PathVariable(value = "id") UUID id) {
		equipmentModelService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
