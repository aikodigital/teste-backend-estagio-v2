package io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionHistoryCreateDTO {

    @NotNull(message = "lat is required")
    private Double lat;

    @NotNull(message = "lon is required")
    private Double lon;
}
