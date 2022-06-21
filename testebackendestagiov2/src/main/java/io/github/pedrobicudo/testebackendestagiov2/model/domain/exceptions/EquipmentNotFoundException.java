package io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions;

public class EquipmentNotFoundException extends DomainException {
    public EquipmentNotFoundException() {
        super("equipment not found");
    }
}
