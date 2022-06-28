package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.EquipmentModel;
import TesteEstagioBackendV2.teste.Service.EquipmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/equipmentModel")
public class EquipmentModelController {

    @Autowired
    private EquipmentModelService equipmentModelService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentModel> save(@RequestBody EquipmentModel equipmentModel){
        return ResponseEntity.ok(equipmentModelService.save(equipmentModel));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<EquipmentModel> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentModelService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EquipmentModel>> getAll(){
        return ResponseEntity.ok(equipmentModelService.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentModel> update(@RequestBody EquipmentModel equipmentModel){
        return ResponseEntity.ok(equipmentModelService.update(equipmentModel));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<EquipmentModel> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentModelService.delete(id));
    }



}
