package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EquipmentStateRequest {
    @NotBlank(message = "Name may not be blank")
    private String name;
}
