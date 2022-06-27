package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EquipmentModelRequest {
    @NotBlank(message = "Name may not be blank")
    private String name;
}
