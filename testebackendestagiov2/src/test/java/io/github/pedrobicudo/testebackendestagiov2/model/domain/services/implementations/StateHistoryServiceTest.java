package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.*;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.StateHistoryRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryUpdateDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StateHistoryServiceTest {

    @Mock
    private StateHistoryRepository stateHistoryRepository;

    @Mock
    private EquipmentStateRepository equipmentStateRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private StateHistoryService service;

    @Test
    @DisplayName("current with non existent equipment id must throw EquipmentNotFoundException")
    public void testCurrentWithNonExistentEquipmentIdMustThrowEquipmentNotFoundException() {
        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.current(UUID.fromString("a7c53eb1-4f5e-4eba-9764-ad205d0891f9"));
        });

        assertEquals("equipment not found", exception.getMessage());
    }

    @Test
    @DisplayName("current with non existent state history must throw StateHistoryNotFoundException")
    public void testCurrentWithNonExistentStateHistoryMustThrowStateHistoryNotFoundException() {
        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Equipment()));

        Mockito.when(stateHistoryRepository.findMostRecentDateFromEquipment(Mockito.any()))
                .thenReturn(new Date());

        Mockito.when(stateHistoryRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(StateHistoryNotFoundException.class, () -> {
            service.current(UUID.fromString("03b2d446-e3ba-4c82-8dc2-a5611fea6e1f"));
        });

        assertEquals("state history not found", exception.getMessage());

    }

    @Test
    @DisplayName("test isPositionHistoryIdValid must return false")
    public void testIsPositionHistoryIdValidMustReturnFalse() {
        String invalid = "";
        assertFalse(service.isStateHistoryIdValid(invalid));

        invalid = "_";
        assertFalse(service.isStateHistoryIdValid(invalid));

        invalid = "_1655993882879";
        assertFalse(service.isStateHistoryIdValid(invalid));

        invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_";
        assertFalse(service.isStateHistoryIdValid(invalid));

        invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879_1655993882879";
        assertFalse(service.isStateHistoryIdValid(invalid));

    }

    @Test
    @DisplayName("test isPositionHistoryIdValid must return true")
    public void testIsPositionHistoryIdValidMustReturnTrue() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";
        assertTrue(service.isStateHistoryIdValid(valid));
    }

    @Test
    @DisplayName("find by id with invalid stateHistoryId must throw InvalidStateHistoryIdException")
    public void testFindByIdWithInvalidStateHistoryIdMustThrowInvalidStateHistoryIdException() {
        String invalid = "";
        DomainException exception = assertThrows(InvalidStateHistoryIdException.class, () -> {
            service.findById(invalid);
        });

        assertEquals("invalid state history id structure", exception.getMessage());
    }

    @Test
    @DisplayName("find by id with non existent equipmentId must throw EquipmentNotFoundException")
    public void testFindByIdWithNonExistentEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.findById(valid);
        });

        assertEquals("equipment not found", exception.getMessage());

    }

    @Test
    @DisplayName("find by id with non existent state history id must throw StateHistoryNotFoundException")
    public void testFindByIdWithNonExistentStateHistoryIdMustThrowStateHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                        .thenReturn(Optional.of(new Equipment()));

        Mockito.when(stateHistoryRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(StateHistoryNotFoundException.class,() -> {
            service.findById(valid);
        });

        assertEquals("state history not found", exception.getMessage());


    }

    @Test
    @DisplayName("delete with invalid stateHistoryId must throw InvalidStateHistoryIdException")
    public void testDeleteWithInvalidStateHistoryIdMustThrowInvalidStateHistoryIdException() {
        String invalid = "";
        DomainException exception = assertThrows(InvalidStateHistoryIdException.class, () -> {
            service.delete(invalid);
        });

        assertEquals("invalid state history id structure", exception.getMessage());
    }

    @Test
    @DisplayName("delete with non existent equipmentId must throw EquipmentNotFoundException")
    public void testDeleteWithNoExistentEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.delete(valid);
        });

        assertEquals("equipment not found", exception.getMessage());
    }

    @Test
    @DisplayName("delete with non existent state history id must throw StateHistoryNotFoundException")
    public void testDeleteWithNonExistentStateHistoryIdMustThrowStateHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Equipment()));

        Mockito.when(stateHistoryRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(StateHistoryNotFoundException.class,() -> {
            service.delete(valid);
        });

        assertEquals("state history not found", exception.getMessage());


    }

    @Test
    @DisplayName("create with non existent equipmentId must throw EquipmentNotFoundException")
    public void testCreateWithNonExistentEquipmentIdMustThrowEquipmentNotFoundException() {
        UUID nonExistent = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.create(nonExistent, new StateHistoryCreateDTO());
        });

        assertEquals("equipment not found", exception.getMessage());
    }

    @Test
    @DisplayName("create with non existent stateId must throw EquipmentStateNotFoundException")
    public void testCreateWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        UUID valid = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        String nonExistent = "aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Equipment(valid, null, null)));

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.create(valid, new StateHistoryCreateDTO(nonExistent));
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("update with invalid stateHistoryId must throw InvalidStateHistoryIdException")
    public void testUpdateWithInvalidStateHistoryIdMustThrowInvalidStateHistoryIdException() {
        String invalid = "";
        DomainException exception = assertThrows(InvalidStateHistoryIdException.class, () -> {
            service.update(invalid, new StateHistoryUpdateDTO());
        });

        assertEquals("invalid state history id structure", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent equipmentId must throw EquipmentNotFoundException")
    public void testUpdateWithNoExistentEquipmentIdMustThrowEquipmentNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentNotFoundException.class, () -> {
            service.update(valid, new StateHistoryUpdateDTO());
        });

        assertEquals("equipment not found", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent stateId must throw EquipmentStateNotFoundException")
    public void testUpdateWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";
        String nonExistent = "aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), null, null)));

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.update(valid, new StateHistoryUpdateDTO(nonExistent));
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent state history must throw StateHistoryNotFoundException")
    public void testUpdateWithNonExistentStateHistoryMustThrowStateHistoryNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_1655993882879";
        String validStateId = "aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89";
        Mockito.when(equipmentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Equipment(UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89"), null, null)));

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState(UUID.fromString(validStateId), null, null)));

        Mockito.when(stateHistoryRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(StateHistoryNotFoundException.class, () -> {
            service.update(valid, new StateHistoryUpdateDTO(validStateId));
        });

        assertEquals("state history not found", exception.getMessage());

    }

}