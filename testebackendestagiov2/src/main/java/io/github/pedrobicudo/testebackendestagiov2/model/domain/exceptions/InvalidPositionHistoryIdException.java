package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class InvalidPositionHistoryIdException extends DomainException {
    public InvalidPositionHistoryIdException() {
        super("invalid position history id structure");
    }
}
