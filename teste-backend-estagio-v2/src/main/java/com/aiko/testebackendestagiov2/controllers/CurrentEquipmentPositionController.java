package com.aiko.testebackendestagiov2.controllers;

import com.aiko.testebackendestagiov2.dtos.responses.CurrentEquipmentPositionResponse;
import com.aiko.testebackendestagiov2.services.GetCurrentEquipmentPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currentEquipmentPosition")
@RequiredArgsConstructor
public class CurrentEquipmentPositionController {

    private final GetCurrentEquipmentPositionService getCurrentEquipmentPositionService;

    @GetMapping
    public List<CurrentEquipmentPositionResponse> getCurrentEquipmentPosition(){
        return getCurrentEquipmentPositionService.execute();
    }
}
