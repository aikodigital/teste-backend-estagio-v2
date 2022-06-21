package io.github.pedrobicudo.testebackendestagiov2.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIError {
    private List<String> message;

    public APIError(String message) {
        this.message = List.of(message);
    }
}
