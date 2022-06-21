package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class StateHistoryNotFoundException extends DomainException {
    public StateHistoryNotFoundException() {
        super("state history not found");
    }
}
