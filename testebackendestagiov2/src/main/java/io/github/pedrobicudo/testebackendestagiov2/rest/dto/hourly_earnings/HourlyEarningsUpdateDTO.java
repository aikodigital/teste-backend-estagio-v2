package io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HourlyEarningsUpdateDTO {

    @NotNull(message = "value is required")
    private Double value;
}
