package com.app.project.services;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipPositionHistoryRepository;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryPostRequestCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryPutRequestCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentPositionHistoryServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");
    final static UUID UUID_INVALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0826");

    @InjectMocks
    private EquipmentPositionHistoryService service;

    @Mock
    private EquipPositionHistoryRepository repository;

    @Mock
    private EquipmentService equipmentService;

    @BeforeEach
    void setUp() throws NotFoundException {
        // EquipmentServiceMock
        BDDMockito.when(equipmentService.findByIdOrThrowNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipCreator.createEquipmentValid());

        BDDMockito.when(repository.findAll())
                .thenReturn(List.of(EquipPositionHistoryCreator.createEquipPositionHistoryValid()));

        BDDMockito.when(repository.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipPositionHistoryCreator.createEquipPositionHistoryValid()));

        // EquipmentPositionHistoryRepositoryMock
        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentPositionHistory.class)))
                .thenReturn(EquipPositionHistoryCreator.createEquipPositionHistoryValid());
    }

    @Test
    @DisplayName("findAll - returns a list of equipment position histories when successful")
    void findAll_ReturnsAListOfEquipmentPositionHistories_WhenSuccessful() {
        UUID expectedEquipmentId = EquipCreator.createEquipmentValid().getId();

        List<EquipmentPositionHistory> equipmentPositionHistory = service.findAll();

        Assertions.assertThat(equipmentPositionHistory).isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipmentPositionHistory.get(0).getEquipment().getId())
                .isEqualTo(expectedEquipmentId);

        Assertions.assertThat(equipmentPositionHistory.get(0).getEquipment().getId())
                .isEqualTo(expectedEquipmentId);
    }

    @Test
    @DisplayName("findById - returns an equipment state history when successful")
    void findById_ReturnsAnEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
        UUID expectedEquipmentId = EquipCreator
                .createEquipmentValid().getId();

        EquipmentPositionHistory equipmentPositionHistory = service.findByIdOrThrowsNotFoundException(UUID_VALID);

        Assertions.assertThat(equipmentPositionHistory).isNotNull();

        Assertions.assertThat(equipmentPositionHistory.getEquipment().getId()).isEqualTo(expectedEquipmentId);
    }

    @Test
    @DisplayName("findById - throws an exception when equipment position history is not found")
    void findById_ThrowsAnException_WhenEquipmentPositionHistoryNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(UUID_INVALID))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findByIdOrThrowsNotFoundException(UUID_INVALID));
    }

    @Test
    @DisplayName("save - returns equipment position history when successful")
    void save_ReturnsEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
        EquipmentPositionHistory equipmentStateHistory = service.save(
                EquipPositionHistoryPostRequestCreator.createEquipPositionHistoryPostRequestCreator());
        Assertions.assertThat(equipmentStateHistory).isNotNull();
    }

    @Test
    @DisplayName("update returns an equipment position history when successful")
    void update_ReturnsAnEquipmentPositionHistory_WhenSuccessful() {
        Assertions.assertThatCode(() -> service.update(
                        EquipPositionHistoryPutRequestCreator.createEquipPositionHistoryPutRequestCreator()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("delete - removes an equipment position history when successful")
    void delete_RemovesAnEquipmentPositionHistory_WhenSuccessful() {
        Assertions.assertThatCode(() -> service.delete(UUID_VALID))
                .doesNotThrowAnyException();
    }
}