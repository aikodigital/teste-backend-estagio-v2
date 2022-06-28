package TesteEstagioBackendV2.teste.Controller;

import TesteEstagioBackendV2.teste.Model.EquipmentModelStateHourlyEarnings;
import TesteEstagioBackendV2.teste.Service.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/equipmentModelStateHourlyEarnings")
public class EquipmentModelStateHourlyEarningsController {

    @Autowired
    private EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentModelStateHourlyEarnings> save(@RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.save(equipmentModelStateHourlyEarnings));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> getById(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EquipmentModelStateHourlyEarnings>> getAll(){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.getAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentModelStateHourlyEarnings> update(@RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.update(equipmentModelStateHourlyEarnings));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<EquipmentModelStateHourlyEarnings> delete(@PathVariable UUID id){
        return ResponseEntity.ok(equipmentModelStateHourlyEarningsService.delete(id));
    }

}
