package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.EquipmentStateHistory;
import TesteEstagioBackendV2.teste.Service.EquipmentStateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/equipment_state_history")
public class EquipmentStateHistoryController {

    @Autowired
    private EquipmentStateHistoryService equipmentStateHistoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentStateHistory> save(@RequestBody EquipmentStateHistory equipment_state_history){
        return ResponseEntity.ok(equipmentStateHistoryService.save(equipment_state_history));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<EquipmentStateHistory> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentStateHistoryService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EquipmentStateHistory>> getAll(){
        return ResponseEntity.ok(equipmentStateHistoryService.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentStateHistory> update(@RequestBody EquipmentStateHistory equipment_state_history){
        return ResponseEntity.ok(equipmentStateHistoryService.update(equipment_state_history));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<EquipmentStateHistory> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentStateHistoryService.delete(id));
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/recent")
    public ResponseEntity<List<EquipmentStateHistory>> getRecent(){
        return ResponseEntity.ok(equipmentStateHistoryService.getRecent());
    }

    
}
