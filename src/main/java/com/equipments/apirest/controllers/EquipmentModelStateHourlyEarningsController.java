package com.equipments.apirest.controllers;

import com.equipments.apirest.controllers.dtos.request.EquipmentHourlyEarningsRequest;
import com.equipments.apirest.controllers.dtos.response.EquipmentHourlyEarningsResponse;
import com.equipments.apirest.models.EquipmentModelStateHourlyEarnings;
import com.equipments.apirest.services.EquipmentModelStateHourlyEarningsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipment-model-state-hourly-earnings")
@AllArgsConstructor
public class EquipmentModelStateHourlyEarningsController {

    @Autowired
    EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;


    @GetMapping
    public List<EquipmentHourlyEarningsResponse> listEquipmentHourlyEarnings(@RequestParam UUID modelId,
                                                                             @RequestParam UUID stateId) {
        final var equipmentHourlyEarnings = this.equipmentModelStateHourlyEarningsService.findAll(modelId, stateId);
        return equipmentHourlyEarnings.stream().map(EquipmentHourlyEarningsResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public EquipmentHourlyEarningsResponse createEquipmentState(@RequestBody EquipmentHourlyEarningsRequest equipmentHourlyEarningsRequest) {
        EquipmentModelStateHourlyEarnings earnings = equipmentHourlyEarningsRequest.toModel();

        earnings = this.equipmentModelStateHourlyEarningsService.create(earnings);

        return new EquipmentHourlyEarningsResponse(earnings);
    }

}
