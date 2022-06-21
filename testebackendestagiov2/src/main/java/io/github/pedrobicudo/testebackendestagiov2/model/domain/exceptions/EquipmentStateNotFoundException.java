package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class EquipmentStateNotFoundException extends DomainException {
    public EquipmentStateNotFoundException() {
        super("equipment state not found");
    }
}
