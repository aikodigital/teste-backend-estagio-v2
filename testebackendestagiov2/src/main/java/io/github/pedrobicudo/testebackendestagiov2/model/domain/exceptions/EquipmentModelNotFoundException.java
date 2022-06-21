package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class EquipmentModelNotFoundException extends DomainException {
    public EquipmentModelNotFoundException() {
        super("equipment model not found");
    }
}
