package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.implementations;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.*;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentModelRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.EquipmentStateRepository;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories.HourlyEarningsRepository;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsUpdateDTO;
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
class HourlyEarningsServiceTest {

    @Mock
    private HourlyEarningsRepository earningsRepository;

    @Mock
    private EquipmentStateRepository equipmentStateRepository;

    @Mock
    private EquipmentModelRepository equipmentModelRepository;

    @InjectMocks
    private HourlyEarningsService service;

    @Test
    @DisplayName("find all with invalid state id must throw EquipmentStateNotFoundException")
    public void testFindAllWithInvalidStateIdMustThrowEquipmentStateNotFoundException() {
        UUID nonExistentId = UUID.fromString("a3540227-2f0e-4362-9517-92f41dabbfdf");

        Mockito.when(equipmentStateRepository.existsById(Mockito.any()))
                .thenReturn(false);

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class, () -> {
            service.findAll(nonExistentId);
        });

        assertEquals("equipment state not found", exception.getMessage());

    }

    @Test
    @DisplayName("test isHourlyEarningsIdValid must return false")
    public void testisHourlyEarningsIdValidMustReturnFalse() {
        String invalid = "";
        assertFalse(service.isHourlyEarningsIdValid(invalid));

        invalid = "_";
        assertFalse(service.isHourlyEarningsIdValid(invalid));

        invalid = "_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";
        assertFalse(service.isHourlyEarningsIdValid(invalid));

        invalid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";
        assertFalse(service.isHourlyEarningsIdValid(invalid));

    }

    @Test
    @DisplayName("test isHourlyEarningsIdValid must return true")
    public void testisHourlyEarningsIdValidMustReturnTrue() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";
        assertTrue(service.isHourlyEarningsIdValid(valid));
    }

    @Test
    @DisplayName("find by id with invalid id structure must throw InvalidHourlyEarningsIdException")
    public void testFindByIdWithInvalidIdStructureMustThrowInvalidHourlyEarningsIdException() {
        String invalid = "";

        DomainException exception = assertThrows(InvalidHourlyEarningsIdException.class, () -> {
            service.findById(invalid);
        });

        assertEquals("invalid hourly earnings id structure", exception.getMessage());
    }

    @Test
    @DisplayName("find by id with non existent state id must throw EquipmentStateNotFoundException")
    public void testFindByIdWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class,() -> {
            service.findById(valid);
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("find by id with non existent model id must throw EquipmentModelNotFoundException")
    public void testFindByIdWithNonExistentModelIdMustThrowEquipmentModelNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class,() -> {
            service.findById(valid);
        });

        assertEquals("equipment model not found", exception.getMessage());
    }

    @Test
    @DisplayName("find by id with non existent hourlyEarningId must throw HourlyEarningsNotFoundException")
    public void testFindByIdWithNonExistentHourlyEarningIdMustThrowHourlyEarningsNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentModel()));

        Mockito.when(earningsRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(HourlyEarningsNotFoundException.class,() -> {
            service.findById(valid);
        });

        assertEquals("hourly earnings not found", exception.getMessage());
    }

    @Test
    @DisplayName("delete with invalid id structure must throw InvalidHourlyEarningsIdException")
    public void testDeleteWithInvalidIdStructureMustThrowInvalidHourlyEarningsIdException() {
        String invalid = "";

        DomainException exception = assertThrows(InvalidHourlyEarningsIdException.class, () -> {
            service.delete(invalid);
        });

        assertEquals("invalid hourly earnings id structure", exception.getMessage());
    }

    @Test
    @DisplayName("delete with non existent state id must throw EquipmentStateNotFoundException")
    public void testDeleteWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class,() -> {
            service.delete(valid);
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("delete with non existent model id must throw EquipmentModelNotFoundException")
    public void testDeleteWithNonExistentModelIdMustThrowEquipmentModelNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class,() -> {
            service.delete(valid);
        });

        assertEquals("equipment model not found", exception.getMessage());
    }

    @Test
    @DisplayName("delete with non existent hourlyEarningId must throw HourlyEarningsNotFoundException")
    public void testDeleteWithNonExistentHourlyEarningIdMustThrowHourlyEarningsNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentModel()));

        Mockito.when(earningsRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(HourlyEarningsNotFoundException.class,() -> {
            service.delete(valid);
        });

        assertEquals("hourly earnings not found", exception.getMessage());
    }

    @Test
    @DisplayName("create with non existent state id must throw EquipmentStateNotFoundException")
    public void testCreateWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        UUID nonExistentStateId = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class,() -> {
            service.create(nonExistentStateId, new HourlyEarningsCreateDTO());
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("create with non existent model id must throw EquipmentModelNotFoundException")
    public void testCreateWithNonExistentModelIdMustThrowEquipmentModelNotFoundException() {
        UUID stateId = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        String nonExistentModelId = "aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class,() -> {
            service.create(stateId, new HourlyEarningsCreateDTO(nonExistentModelId, null));
        });

        assertEquals("equipment model not found", exception.getMessage());
    }

    @Test
    @DisplayName("create earning with already existing primary key must throw HourlyEarningsAlreadyExistsException")
    public void createEarningWithAlreadyExistingPrimaryKeyMustThrowHourlyEarningsAlreadyExistsException() {
        UUID stateId = UUID.fromString("bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89");
        String modelId = "aa733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentModel()));

        Mockito.when(earningsRepository.existsById(Mockito.any()))
                .thenReturn(true);

        DomainException exception = assertThrows(HourlyEarningsAlreadyExistsException.class,() -> {
            service.create(stateId, new HourlyEarningsCreateDTO(modelId, null));
        });

        assertEquals("hourly earnings already exists", exception.getMessage());
    }

    @Test
    @DisplayName("update with invalid id structure must throw InvalidHourlyEarningsIdException")
    public void testUpdateWithInvalidIdStructureMustThrowInvalidHourlyEarningsIdException() {
        String invalid = "";

        DomainException exception = assertThrows(InvalidHourlyEarningsIdException.class, () -> {
            service.update(invalid, new HourlyEarningsUpdateDTO());
        });

        assertEquals("invalid hourly earnings id structure", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent state id must throw EquipmentStateNotFoundException")
    public void testUpdateWithNonExistentStateIdMustThrowEquipmentStateNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentStateNotFoundException.class,() -> {
            service.update(valid, new HourlyEarningsUpdateDTO());
        });

        assertEquals("equipment state not found", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent model id must throw EquipmentModelNotFoundException")
    public void testUpdateWithNonExistentModelIdMustThrowEquipmentModelNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(EquipmentModelNotFoundException.class,() -> {
            service.update(valid, new HourlyEarningsUpdateDTO());
        });

        assertEquals("equipment model not found", exception.getMessage());
    }

    @Test
    @DisplayName("update with non existent hourlyEarningId must throw HourlyEarningsNotFoundException")
    public void testUpdateWithNonExistentHourlyEarningIdMustThrowHourlyEarningsNotFoundException() {
        String valid = "bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89_bb733549-d2cc-40f0-b7f3-9bfa9f3c1b89";

        Mockito.when(equipmentStateRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentState()));

        Mockito.when(equipmentModelRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new EquipmentModel()));

        Mockito.when(earningsRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        DomainException exception = assertThrows(HourlyEarningsNotFoundException.class,() -> {
            service.delete(valid);
        });

        assertEquals("hourly earnings not found", exception.getMessage());
    }

}