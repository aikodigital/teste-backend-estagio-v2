package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.EquipmentPositionHistory;
import TesteEstagioBackendV2.teste.Model.EquipmentStateHistory;
import TesteEstagioBackendV2.teste.Service.EquipmentPositionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/equipmentPositionHistory")
public class EquipmentPositionHistoryController {
    @Autowired
    private EquipmentPositionHistoryService equipmentPositionHistoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentPositionHistory> save(@RequestBody EquipmentPositionHistory equipmentPositionHistory){
        return ResponseEntity.ok(equipmentPositionHistoryService.save(equipmentPositionHistory));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<EquipmentPositionHistory> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentPositionHistoryService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EquipmentPositionHistory>> getAll(){
        return ResponseEntity.ok(equipmentPositionHistoryService.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentPositionHistory> update(@RequestBody EquipmentPositionHistory equipmentPositionHistory){
        return ResponseEntity.ok(equipmentPositionHistoryService.update(equipmentPositionHistory));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<EquipmentPositionHistory> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentPositionHistoryService.delete(id));
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/recent")
    public ResponseEntity<List<EquipmentPositionHistory>> getRecent(){
        return ResponseEntity.ok(equipmentPositionHistoryService.getRecent());
    }

}
