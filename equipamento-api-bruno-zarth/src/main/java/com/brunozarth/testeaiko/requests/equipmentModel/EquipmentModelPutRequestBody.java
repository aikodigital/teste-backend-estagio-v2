package com.brunozarth.testeaiko.requests.equipmentModel;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentModelPutRequestBody {

    private UUID id;

    @NotEmpty(message = "Equipment name cant be empty")
    @NotNull(message = "Equipment name cant be null")
    private String name;

}
