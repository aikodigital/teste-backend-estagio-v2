package io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history;

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
public class StateHistoryUpdateDTO {

    @NotNull(message = "state_id is required")
    @NotEmpty(message = "state_id is required")
    private String stateId;
}
