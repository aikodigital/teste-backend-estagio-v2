package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment;

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
public class EquipmentUpdateDTO {

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "model_id is required")
    @NotEmpty(message = "model_id is required")
    private String modelId;

}
