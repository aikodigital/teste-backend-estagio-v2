package com.brunozarth.testeaiko.requests.equipmentModel;

import com.brunozarth.testeaiko.model.EquipmentModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EquipmentModelPostRequestBody {

    //private UUID id;

    @NotEmpty(message = "Equipment name cant be empty")
    @NotNull(message = "Equipment name cant be null")
    private String name;

}
