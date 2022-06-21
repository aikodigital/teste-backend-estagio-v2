package io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings;

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
public class HourlyEarningsCreateDTO {

    @NotNull(message = "model_id is required")
    @NotEmpty(message = "model_id is required")
    private String modelId;

    @NotNull(message = "value is required")
    private Double value;
}
