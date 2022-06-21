package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model;

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
public class EquipmentModelCreateDTO {
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;
}
