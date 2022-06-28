package com.app.project.services;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipStateHistoryRepository;
import com.app.project.util.equipStateHistory.EquipStateHistoryCreator;
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
class EquipmentStateHistoryServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");
    final static UUID UUID_INVALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0826");

    @InjectMocks
    private EquipmentStateHistoryService service;

    @Mock
    private EquipStateHistoryRepository repository;

    @BeforeEach()
    void setUp() {
        // TODO: check the reason's nullPointerException
//        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentStateHistory.class)))
//                .thenReturn(EquipStateHistoryCreator.createEquipStateHistoryValid());

        BDDMockito.when(repository.findAll())
                .thenReturn(List.of(EquipStateHistoryCreator.createEquipStateHistoryValid()));

        BDDMockito.when(repository.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipStateHistoryCreator.createEquipStateHistoryValid()));
    }

    // TODO: check the reason's nullPointerException
//    @Test
//    @DisplayName("save - returns equipment state history when successful")
//    void save_ReturnsEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
//        EquipmentStateHistory equipmentStateHistory = service.save(
//                EquipStateHistoryPostRequestCreator.createEquipStateHistoryPostRequestServiceCreator());
//
//        Assertions.assertThat(equipmentStateHistory).isNotNull();
//    }

    @Test
    @DisplayName("findAll - returns a list of equipment states histories when successful")
    void findAll_ReturnsAListOfEquipmentStatesHistories_WhenSuccessful() {
        UUID expectedEquipmentId = EquipStateHistoryCreator
                .createEquipStateHistoryValid().getEquipment().getId();
        UUID expectedEquipmentStateId = EquipStateHistoryCreator
                .createEquipStateHistoryValid().getEquipment().getId();

        List<EquipmentStateHistory> equipmentStateHistory = service.findAll();

        Assertions.assertThat(equipmentStateHistory).isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipmentStateHistory.get(0).getEquipment().getId())
                .isEqualTo(expectedEquipmentId);

        Assertions.assertThat(equipmentStateHistory.get(0).getEquipment().getId())
                .isEqualTo(expectedEquipmentStateId);
    }

    @Test
    @DisplayName("findById - returns an equipment state history when successful")
    void findById_ReturnsAnEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
        UUID expectedEquipmentId = EquipStateHistoryCreator
                .createEquipStateHistoryValid().getEquipment().getId();
        UUID expectedEquipmentStateId = EquipStateHistoryCreator
                .createEquipStateHistoryValid().getEquipment().getId();

        EquipmentStateHistory equipmentStateHistory = service.findById(UUID_VALID);

        Assertions.assertThat(equipmentStateHistory).isNotNull();

        Assertions.assertThat(equipmentStateHistory.getEquipment().getId()).isEqualTo(expectedEquipmentId);

        Assertions.assertThat(equipmentStateHistory.getEquipment().getId()).isEqualTo(expectedEquipmentStateId);
    }

    @Test
    @DisplayName("findById - throws an exception when equipment state history is not found")
    void findById_ThrowsAnException_WhenEquipmentStateHistoryNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(UUID_INVALID))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findById(UUID_INVALID));
    }
}