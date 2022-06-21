package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.DomainException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentStateNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateUpdateDTO;
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
class EquipmentStateServiceTest {

    @Mock
    private EquipmentStateRepository repository;

    @InjectMocks
    private EquipmentStateService service;

    @Test
    @DisplayName("find by id with invalid id must throw EquipmentStateNotFoundException")
    public void testFindByIdWithInvalidIdMustThrowEquipmentStateNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.findById(nonExistentId);
        });

        assertEquals("equipment state not found", exception.getMessage());

    }

    @Test
    @DisplayName("update by id must throw EquipmentStateNotFoundException")
    public void testUpdateWithInvalidIdMustThrowEquipmentStateNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        EquipmentStateUpdateDTO update = new EquipmentStateUpdateDTO(
                "foo",
                "#bar"
        );

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.update(nonExistentId, update);
        });

        assertEquals("equipment state not found", exception.getMessage());

    }

    @Test
    @DisplayName("delete inexisting id must throw EquipmentStateNotFoundException")
    public void testDeleteInexistentIdMustThrowEquipmentStateNotFoundException() {
        // Given
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        // Set Up
        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        // When & Then
        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.delete(nonExistentId);
        });

        assertEquals("equipment state not found", exception.getMessage());

    }

}