package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.EquipmentState;
import TesteEstagioBackendV2.teste.Service.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/equipmentState")
public class EquipmentStateController {

    @Autowired
    private EquipmentStateService equipmentStateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentState> save(@RequestBody EquipmentState equipmentState){
        return ResponseEntity.ok(equipmentStateService.save(equipmentState));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<EquipmentState> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentStateService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EquipmentState>> getAll(){
        return ResponseEntity.ok(equipmentStateService.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentState> update(@RequestBody EquipmentState equipmentState){
        return ResponseEntity.ok(equipmentStateService.update(equipmentState));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<EquipmentState> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentStateService.delete(id));
    }
}
