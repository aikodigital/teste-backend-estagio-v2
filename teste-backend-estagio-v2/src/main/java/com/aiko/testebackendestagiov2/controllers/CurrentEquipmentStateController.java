package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.responses.CurrentEquipmentStateResponse;
import com.aiko.testebackendestagiov2.services.GetCurrentEquipmentStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currentEquipmentState")
@RequiredArgsConstructor
public class CurrentEquipmentStateController {

    private final GetCurrentEquipmentStateService getCurrentEquipmentStateService;

    @GetMapping
    public List<CurrentEquipmentStateResponse> getCurrentEquipmentState(){
        return getCurrentEquipmentStateService.execute();
    }
}
