package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class PositionHistoryNotFoundException extends DomainException {
    public PositionHistoryNotFoundException() {
        super("position history not found");
    }
}
