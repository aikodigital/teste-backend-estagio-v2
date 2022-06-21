package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class InvalidHourlyEarningsIdException extends DomainException {
    public InvalidHourlyEarningsIdException() {
        super("invalid hourly earnings id structure");
    }
}
