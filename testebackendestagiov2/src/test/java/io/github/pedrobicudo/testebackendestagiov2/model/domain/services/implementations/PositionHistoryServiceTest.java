package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.DomainException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidPositionHistoryIdException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.PositionHistoryNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.PositionHistoryRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryUpdateDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PositionHistoryServiceTest {

    @Mock
    private PositionHistoryRepository positionRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private PositionHistoryService service;

    @Test
    @DisplayName("find all with invalid equipment id must throw equipment not found exception")
    public void testFindAllWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        Mockito.when(equipmentRepository.existsById(Mockito.any()))
                .thenReturn(false);

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.findAll(UUID.fromString("aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89"));
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("find current with invalid equipment id must throw EquipmentNotFoundException")
    public void testFindCurrentWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenThrow(new EquipmentNotFoundException());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.current(UUID.fromString("aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89"));
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("find current with invalid primary key must throw PositionHistoryNotFoundException")
    public void testFindCurrentWithInvalidPrimaryKeyMustThrowPositionHistoryNotFoundException() {
        Equipment found = new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), "a", new EquipmentModel());

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                        .thenReturn(Optional.of(found));

        Mockito.when(positionRepository.findById(Mockito.any()))
                .thenThrow(new PositionHistoryNotFoundException());

        DomainException exception = assertThrows(PositionHistoryNotFoundException.class, () -> {
            service.current(UUID.fromString("aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89"));
        });

        assertEquals("position history not found", exception.getMessage());

    }

    @Test
    @DisplayName("test isPositionHistoryIdValid must return false")
    public void testIsPositionHistoryIdValidMustReturnFalse() {
        String invalid = "";
        assertFalse(service.isPositionHistoryIdValid(invalid));

        invalid = "_";
        assertFalse(service.isPositionHistoryIdValid(invalid));

        invalid = "_1655993882879";
        assertFalse(service.isPositionHistoryIdValid(invalid));

        invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_";
        assertFalse(service.isPositionHistoryIdValid(invalid));

        invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879_1655993882879";
        assertFalse(service.isPositionHistoryIdValid(invalid));

    }

    @Test
    @DisplayName("test isPositionHistoryIdValid must return true")
    public void testIsPositionHistoryIdValidMustReturnTrue() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";
        assertTrue(service.isPositionHistoryIdValid(valid));
    }

    @Test
    @DisplayName("test findById with invalid id must throw InvalidPositionHistoryIdException")
    public void testFindByIdWithInvalidIdMustThrowInvalidPositionHistoryIdException() {
        String invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_";
        DomainException exception = assertThrows(InvalidPositionHistoryIdException.class, () -> {
            service.findById(invalid);
        });

        assertEquals("invalid position history id structure",exception.getMessage());

    }

    @Test
    @DisplayName("test findById with invalid equipment id must throw EquipmentNotFoundException")
    public void testFindByIdWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenThrow(new EquipmentNotFoundException());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.findById(valid);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("test findById with invalid primary key must throw PositionHistoryNotFoundException")
    public void testFindByIdWithInvalidEquipmentIdMustThrowPositionHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Equipment found = new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), "a", new EquipmentModel());

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(found));

        Mockito.when(positionRepository.findById(Mockito.any()))
                .thenThrow(new PositionHistoryNotFoundException());

        DomainException exception = assertThrows(PositionHistoryNotFoundException.class, () -> {
            service.findById(valid);
        });

        assertEquals("position history not found", exception.getMessage());

    }

    @Test
    @DisplayName("test delete with invalid id must throw InvalidPositionHistoryIdException")
    public void testDeleteWithInvalidIdMustThrowInvalidPositionHistoryIdException() {
        String invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_";
        DomainException exception = assertThrows(InvalidPositionHistoryIdException.class, () -> {
            service.delete(invalid);
        });

        assertEquals("invalid position history id structure",exception.getMessage());

    }

    @Test
    @DisplayName("test delete with invalid equipment id must throw EquipmentNotFoundException")
    public void testDeleteWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenThrow(new EquipmentNotFoundException());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.delete(valid);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("test delete with invalid primary key must throw PositionHistoryNotFoundException")
    public void testDeleteWithInvalidPrimaryKeyMustThrowPositionHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Equipment found = new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), "a", new EquipmentModel());

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(found));

        Mockito.when(positionRepository.findById(Mockito.any()))
                .thenThrow(new PositionHistoryNotFoundException());

        DomainException exception = assertThrows(PositionHistoryNotFoundException.class, () -> {
            service.delete(valid);
        });

        assertEquals("position history not found", exception.getMessage());

    }

    @Test
    @DisplayName("test create with invalid equipment id must throw EquipmentNotFoundException")
    public void testCreateWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        UUID nonExitentId = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenThrow(new EquipmentNotFoundException());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.create(nonExitentId, new PositionHistoryCreateDTO());
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("test update with invalid id must throw InvalidPositionHistoryIdException")
    public void testUpdateWithInvalidIdMustThrowInvalidPositionHistoryIdException() {
        String invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_";
        DomainException exception = assertThrows(InvalidPositionHistoryIdException.class, () -> {
            service.update(invalid, new PositionHistoryUpdateDTO());
        });

        assertEquals("invalid position history id structure",exception.getMessage());

    }

    @Test
    @DisplayName("test update with invalid equipment id must throw EquipmentNotFoundException")
    public void testUpdateWithInvalidEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenThrow(new EquipmentNotFoundException());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.update(valid, new PositionHistoryUpdateDTO());
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("test delete with invalid prṕimary key must throw PositionHistoryNotFoundException")
    public void testUpdateWithInvalidPrimaryKeyMustThrowPositionHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Equipment found = new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), "a", new EquipmentModel());

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(found));

        Mockito.when(positionRepository.findById(Mockito.any()))
                .thenThrow(new PositionHistoryNotFoundException());

        DomainException exception = assertThrows(PositionHistoryNotFoundException.class, () -> {
            service.delete(valid);
        });

        assertEquals("position history not found", exception.getMessage());

    }

}