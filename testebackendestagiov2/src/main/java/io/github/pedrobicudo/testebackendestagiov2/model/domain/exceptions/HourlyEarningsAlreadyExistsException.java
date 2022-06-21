package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class HourlyEarningsAlreadyExistsException extends DomainException {
    public HourlyEarningsAlreadyExistsException() {
        super("hourly earnings already exists");
    }
}
