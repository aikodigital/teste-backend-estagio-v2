package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
