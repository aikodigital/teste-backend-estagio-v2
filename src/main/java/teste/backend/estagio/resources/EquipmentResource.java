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
import teste.backend.estagio.entities.Equipment;
import teste.backend.estagio.services.EquipmentService;

@RestController
@RequestMapping(value = "/api")
public class EquipmentResource {


	@Autowired
	private EquipmentService equipmentService;

	@GetMapping("/equipments")
	@ApiOperation(value = "Retorna todos os registros de equipamentos do banco")
	public ResponseEntity<List<Equipment>> findAll() {
		List<Equipment> list = equipmentService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/equipments/{id}")
	@ApiOperation(value = "Retorna um registo de equipamento do banco com determinado ID passado")
	public ResponseEntity<Equipment> findById(@PathVariable(value = "id") UUID id) {
		Equipment equipment = equipmentService.findById(id);
		return ResponseEntity.ok().body(equipment);
	}

	@PostMapping("/equipments")
	@ApiOperation(value = "Insere um novo registro de equipamento no banco")
	public ResponseEntity<Equipment> insert(@RequestBody Equipment equipment) {
		equipment = equipmentService.insert(equipment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipment.getId())
				.toUri();
		return ResponseEntity.created(uri).body(equipment);
	}

	@PutMapping("/equipments/{id}")
	@ApiOperation(value = "Altera um determinado registro no banco de acordo com o ID passado")
	public ResponseEntity<Equipment> update(@PathVariable UUID id, @RequestBody Equipment equipment) {
		equipment = equipmentService.update(id,equipment);
		return ResponseEntity.ok().body(equipment);
	}

	@DeleteMapping("/equipments/{id}")
	@ApiOperation(value = "Deleta um determinado registro no banco de acordo com o ID passado")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id) {
		equipmentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
