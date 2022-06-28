package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.Equipment;
import TesteEstagioBackendV2.teste.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipment_service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> save(@RequestBody Equipment equipment){
        return ResponseEntity.ok(equipment_service.save(equipment));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Equipment> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipment_service.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<Equipment>> getAll(){
        return ResponseEntity.ok(equipment_service.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> update(@RequestBody Equipment equipment){
        return ResponseEntity.ok(equipment_service.update(equipment));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<Equipment> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipment_service.delete(id));
    }



}
