package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class HourlyEarningsNotFoundException extends DomainException {
    public HourlyEarningsNotFoundException() {
        super("hourly earnings not found");
    }
}
