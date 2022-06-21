package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.DomainException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentModelNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelUpdateDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EquipmentModelServiceTest {

    @Mock
    private EquipmentModelRepository repository;

    @InjectMocks
    private EquipmentModelService service;

    @Test
    @DisplayName("find by id with invalid id must throw EquipmentModelNotFoundException")
    public void testFindByIdWithInvalidIdMustThrowEquipmentModelNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class, () -> {
            service.findById(nonExistentId);
        });

        assertEquals("equipment model not found", exception.getMessage());

    }

    @Test
    @DisplayName("update by id must throw EquipmentModelNotFoundException")
    public void testUpdateWithInvalidIdMustThrowEquipmentModelNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        EquipmentModelUpdateDTO update = new EquipmentModelUpdateDTO(
                "foo"
        );

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException e = assertThrows(EquipmentModelNotFoundException.class, () -> {
            service.update(nonExistentId, update);
        });

        assertEquals("equipment model not found", e.getMessage());

    }

    @Test
    @DisplayName("delete inexisting id must throw EquipmentModelNotFoundException")
    public void testDeleteInexistentIdMustThrowEquipmentModelNotFoundException() {
        // Given
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        // Set Up
        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        // When & Then
        DomainException exception = assertThrows(EquipmentModelNotFoundException.class, () -> {
            service.delete(nonExistentId);
        });

        assertEquals("equipment model not found", exception.getMessage());

    }

}