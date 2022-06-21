package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentStateCreateDTO {

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "name is required")
    @NotEmpty(message = "color is required")
    private String color;
}
