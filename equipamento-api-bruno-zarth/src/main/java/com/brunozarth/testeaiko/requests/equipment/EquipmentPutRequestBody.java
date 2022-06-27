package com.brunozarth.testeaiko.requests.equipment;

import com.brunozarth.testeaiko.model.EquipmentModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentPutRequestBody {
    private UUID id;

    //@NotEmpty(message = "Equipment model cant be empty")
    //@NotNull(message = "Equipment model cant be null")
    private EquipmentModel equipmentModel;

    @NotEmpty(message = "Equipment name cant be empty")
    @NotNull(message = "Equipment name cant be null")
    private String name;
}
