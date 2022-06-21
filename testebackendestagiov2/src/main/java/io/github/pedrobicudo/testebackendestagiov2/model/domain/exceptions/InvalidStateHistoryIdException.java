package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class InvalidStateHistoryIdException extends DomainException {
    public InvalidStateHistoryIdException() {
        super("invalid state history id structure");
    }
}
