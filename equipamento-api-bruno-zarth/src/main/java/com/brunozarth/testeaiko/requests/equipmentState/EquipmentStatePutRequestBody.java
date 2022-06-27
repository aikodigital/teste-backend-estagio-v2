package com.brunozarth.testeaiko.requests.equipmentState;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentStatePutRequestBody {

    private UUID id;

    @NotEmpty(message = "Equipment state name cant be empty")
    @NotNull(message = "Equipment state name cant be null")
    private String name;

    @NotEmpty(message = "Equipment state color cant be empty")
    @NotNull(message = "Equipment state color cant be null")
    private String color;
}
