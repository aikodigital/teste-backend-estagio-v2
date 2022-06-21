package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.DomainException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentModelNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentUpdateDTO;
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
class EquipmentServiceTest {

    @Mock
    private EquipmentRepository repository;

    @Mock
    private EquipmentModelRepository equipmentModelRepository;

    @InjectMocks
    private EquipmentService service;

    @Test
    @DisplayName("find by id with invalid id must throw EquipmentNotFoundException")
    public void testFindByIdWithInvalidIdMustThrowEquipmentNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.findById(nonExistentId);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("update by id must with invalid model id must throw EquipmentModelNotFoundException")
    public void testUpdateWithInvalidIdMustThrowEquipmentModelNotFoundException() {
        UUID id = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        EquipmentUpdateDTO update = new EquipmentUpdateDTO(
                "foo",
                "fe8a03d7-6495-4231-9843-8ee2f5282620"
        );

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                        .thenThrow(new EquipmentModelNotFoundException());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class, () -> {
            service.update(id, update);
        });

        assertEquals("equipment model not found", exception.getMessage());

    }

    @Test
    @DisplayName("update by id must throw EquipmentNotFoundException")
    public void testUpdateWithInvalidIdMustThrowEquipmentNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        EquipmentUpdateDTO update = new EquipmentUpdateDTO(
                "foo",
                "fe8a03d7-6495-4231-9843-8ee2f5282620"
        );

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                        .thenReturn(Optional.of(
                                new EquipmentModel(
                                    UUID.fromString("fe8a03d7-6495-4231-9843-8ee2f5282620"),
                                    "foo"
                                )
                        ));

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.update(nonExistentId, update);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("delete inexisting id must throw EquipmentNotFoundException")
    public void testDeleteInexistentIdMustThrowEquipmentNotFoundException() {
        UUID nonExistentId = UUID.fromString("2b733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(repository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.delete(nonExistentId);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

}