package com.aiko.apicrud.resources;

/**
 *
 * @author Celso França Neto
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiko.apicrud.repository.EquipmentModelRepository;
import com.aiko.apicrud.repository.EquipmentModelStateHourlyEarningsRepository;
import com.aiko.apicrud.repository.EquipmentPositionHistoryRepository;
import com.aiko.apicrud.repository.EquipmentRepository;
import com.aiko.apicrud.repository.EquipmentStateHistoryRepository;
import com.aiko.apicrud.repository.EquipmentStateRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.aiko.apicrud.models.Equipment;
import com.aiko.apicrud.models.EquipmentModel;
import com.aiko.apicrud.models.EquipmentModelStateHourlyEarnings;
import com.aiko.apicrud.models.EquipmentPositionHistory;
import com.aiko.apicrud.models.EquipmentState;
import com.aiko.apicrud.models.EquipmentStateHistory;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API CRUD - Aiko Equipments Informations")
@CrossOrigin(origins = "*") 
public class Resources {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentStateRepository equipmentStateRepository;

    @Autowired
    EquipmentModelRepository equipmentModelRepository;

    @Autowired
    EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    @Autowired
    EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    @Autowired
    EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    // equipament resources

    @GetMapping("/equipments")
   @ApiOperation(value="Retorna uma lista de todos os equipamentos")
    public List<Equipment> listEquipments() {
        return equipmentRepository.findAll();
    }

    @GetMapping("/equipment/{id}")
   @ApiOperation(value = "Retorna um equimento encontrado pelo id")
    public Equipment getEquipmentById(@PathVariable(value = "id") UUID id) {
        return equipmentRepository.findById(id);
    }

    @PostMapping("/equipment")
    @ApiOperation(value = "Posta um novo equipamento")
    public Equipment postEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @DeleteMapping("/equipment")
   @ApiOperation(value = "Deleta um equipamento")
    public void deleteEquipment(@RequestBody Equipment equipment) {
        try {
            equipmentRepository.delete(equipment);
        } catch (Exception PSQLException) {
            System.out.println("Esse elemento de equipment esta sendo utlizado em outra(s) tabela(s), excluir essa(s) ocorrencia(s) antes de apagar o seu registro em equipment");
        }
    }

    @PutMapping("/equipment")
   @ApiOperation(value = "Edita um equipamento existente")
    public Equipment putEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    // equipament_state resources
    
    @GetMapping("/equipments_state")
    @ApiOperation(value = "Retorna uma lista de todos os estado de equipamentos")
    public List<EquipmentState> listEquipmentSate() {
        return equipmentStateRepository.findAll();
    }

   @GetMapping("/equipment_state/{id}")
   @ApiOperation(value = "Retorna um estado de equipamento buscado por Id")
    public EquipmentState getEquipmentStateById(@PathVariable(value = "id") UUID id) {
        return equipmentStateRepository.findById(id);
    }

    @PostMapping("/equipment_state")
    @ApiOperation(value = "Posta um novo estado de equipamento")
    public EquipmentState postEquipmentState(@RequestBody EquipmentState equipmentState) {
        return equipmentStateRepository.save(equipmentState);
    }

    @DeleteMapping("/equipment_state")
    @ApiOperation(value = "Deleta um estado de equipamento")
    public void deleteEquipmentState(@RequestBody EquipmentState equipmentState) {
        try {
            equipmentStateRepository.delete(equipmentState);
        } catch (Exception PSQLException) {
            System.out.println("Esse elemento de equipment_state esta sendo utlizado em outra(s) tabela(s), excluir essa(s) ocorrencia(s) antes de apagar o seu registro em equipment_state");
        }
    }

    @PutMapping("/equipment_state")
    @ApiOperation(value = "Edita um estado de equipamento existente")
    public EquipmentState putEquipmentState(@RequestBody EquipmentState equipmentState) {
        return equipmentStateRepository.save(equipmentState);
    }

    // equipmant_model resources

    @GetMapping("/equipments_model")
    @ApiOperation(value = "Retorna uma lista de todos os modelos de equipamento")
    public List<EquipmentModel> listEquipmentModel() {
        return equipmentModelRepository.findAll();
    }

    @GetMapping("/equipment_model/{id}")
    @ApiOperation(value = "Retorna um modelo de equipamento buscado por id")
    public EquipmentModel getEquipmentModelById(@PathVariable(value = "id") UUID id) {
        return equipmentModelRepository.findById(id);
    }

    @PostMapping("/equipment_model")
    @ApiOperation(value = "Posta um novo modelo de equipamento")
    public EquipmentModel postEquipmentModel(@RequestBody EquipmentModel equipmentModel) {
        return equipmentModelRepository.save(equipmentModel);
    }

    @DeleteMapping("/equipment_model") 
    @ApiOperation(value = "Deleta um modelo de equipamento")
    public void deleteEquipmentModel(@RequestBody EquipmentModel equipmentModel) {
        try {
            equipmentModelRepository.delete(equipmentModel);
        } catch (Exception PSQLException) {
            System.out.println("Esse elemento de equipment_model esta sendo utlizado em outra(s) tabela(s), excluir essa(s) ocorrencia(s) antes de apagar o seu registro em equipment_model");
        }
    }

    @PutMapping("/equipment_model")
    @ApiOperation(value = "Edita um modelo de equipamento existente")
    public EquipmentModel putEquipmentModel(@RequestBody EquipmentModel equipmentModel) {
        return equipmentModelRepository.save(equipmentModel);
    }

    // equipment_model_state_hourly_earnings resources

    @GetMapping("/equipments_model_state_hourly_earnings")
    @ApiOperation(value = "Retorna uma lista de todos os ganhos por hora por estado")
    public List<EquipmentModelStateHourlyEarnings> listEquipmentModelStateHourlyEarnings() {
        return equipmentModelStateHourlyEarningsRepository.findAll();
    }

    @GetMapping("/equipments_model_state_hourly_earnings/{id}")
    @ApiOperation(value = "Retorna uma lista de ganhos por hora por estado buscados por id estrangeiro")
    public List<EquipmentModelStateHourlyEarnings> getEquipmentModelStateHourlyEarnings(
            @PathVariable(value = "id") UUID id) {
        List<EquipmentModelStateHourlyEarnings> res = new ArrayList<>();

        for (EquipmentModelStateHourlyEarnings it : equipmentModelStateHourlyEarningsRepository.findAll()) {
            if ((it.getEquipmentModel().getId().equals(id)) || (it.getEquipmentState().getId().equals(id))) {
                res.add(it);
            }
        }
        return res;
    }

    @PostMapping("/equipment_model_state_hourly_earnings")
    @ApiOperation(value = "Posta um novo ganho por hora por estado")
    public EquipmentModelStateHourlyEarnings postEquipmentModelStateHourlyEarnings(
            @RequestBody EquipmentModelStateHourlyEarnings equipmentStateModelStateHourlyEarnings) {
        return equipmentModelStateHourlyEarningsRepository.save(equipmentStateModelStateHourlyEarnings);
    }

    @DeleteMapping("/equipment_model_state_hourly_earnings")
    @ApiOperation(value = "Deleta um Ganhos por hora por estado")
    public void deleteEquipmentModelStateHourlyEarningsl(
            @RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        equipmentModelStateHourlyEarningsRepository.delete(equipmentModelStateHourlyEarnings);
    }

    @PutMapping("/equipment_model_state_hourly_earnings")
    @ApiOperation(value = "Edita um Ganhos por hora por estado já existente")
    public EquipmentModelStateHourlyEarnings putEquipmentModelStateHourlyEarnings(
            @RequestBody EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        return equipmentModelStateHourlyEarningsRepository.save(equipmentModelStateHourlyEarnings);
    }

    // equipment_state_history resources

    @GetMapping("/equipments_state_history")
    @ApiOperation(value = "Retorna uma lista de todos os históricos de estados de um equipamento")
    public List<EquipmentStateHistory> listEquipmentStateHistory() {
        return equipmentStateHistoryRepository.findAll();
    }

    @GetMapping("/equipments_state_history/{id}")
    @ApiOperation(value = "Retorna uma lista de histórico de estados de um equipamento buscado por Id")
    public List<EquipmentStateHistory> getEquipmentsStateHistory(@PathVariable(value = "id") UUID id) {
        List<EquipmentStateHistory> res = new ArrayList<>();

        for (EquipmentStateHistory it : equipmentStateHistoryRepository.findAll()) {
            if ((it.getEquipment().getId().equals(id)) || (it.getEquipmentState().getId().equals(id))) {
                res.add(it);
            }
        }
        return res;
    }

    @PostMapping("/equipment_state_history")
   @ApiOperation(value = "Posta um novo histórico de estados de um equipamento")
    public EquipmentStateHistory postEquipmentsStateHistory(@RequestBody EquipmentStateHistory equipmentStateHistory) {
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    @DeleteMapping("/equipment_state_history")
    @ApiOperation(value = "Deleta um histórico de estados de um equipamento")
    public void deletEquipmentStateHistory(@RequestBody EquipmentStateHistory equipmentStateHistory) {
        equipmentStateHistoryRepository.delete(equipmentStateHistory);
    }

    @PutMapping("/equipment_state_history")
    @ApiOperation(value = "Edita um histórico de estados de um equipamento existente")
    public EquipmentStateHistory putEquipmentsStateHistory(@RequestBody EquipmentStateHistory equipmentStateHistory) {
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    // equipment_position_history resources

    @GetMapping("/equipments_position_history")
    @ApiOperation(value = "Retorna uma lista de todos os históricos de posições de um equipamento")
    public List<EquipmentPositionHistory> listEquipmentPositionHistory() {
        return equipmentPositionHistoryRepository.findAll();

    }

    @GetMapping("/equipments_position_history/{id}")
    @ApiOperation(value = "Retorna uma lista de histórico de posições de um equipamento buscados por Id estrangeiro")
    public List<EquipmentPositionHistory> getEquipmentsPositionHistory(@PathVariable(value = "id") UUID id) {
        List<EquipmentPositionHistory> res = new ArrayList<>();

        for (EquipmentPositionHistory it : equipmentPositionHistoryRepository.findAll()) {
            if ((it.getEquipment().getId().equals(id)) || (it.getEquipment().getEquipmentModel().getId().equals(id))) {
                res.add(it);
            }
        }
        return res;
    }

    @PostMapping("/equipment_position_history")
    @ApiOperation(value = "Posta um novo histórico de posições de um equipamento")
    public EquipmentPositionHistory postEquipmentsPositionHistory(
            @RequestBody EquipmentPositionHistory equipmentPositionHistory) {
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }

    @DeleteMapping("/equipment_position_history")
    @ApiOperation(value = "Deleta um histórico de posições de um equipamento")
    public void deletEquipmentsPositionHistory(@RequestBody EquipmentPositionHistory equipmentPositionHistory) {
        equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
    }

    @PutMapping("/equipment_position_history")
    @ApiOperation(value = "Edita um histórico de posições de um equipamento.")
    public EquipmentPositionHistory putEquipmentsPositionHistory(
            @RequestBody EquipmentPositionHistory equipmentPositionHistory) {
        return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
    }
}
