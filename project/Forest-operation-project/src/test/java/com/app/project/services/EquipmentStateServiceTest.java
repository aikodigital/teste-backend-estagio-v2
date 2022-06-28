package com.app.project.services;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipStateRepository;
import com.app.project.util.equipState.EquipStateCreator;
import com.app.project.util.equipState.EquipStatePostRequestCreator;
import com.app.project.util.equipState.EquipStatePutRequestCreator;
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
class EquipmentStateServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");
    final static UUID UUID_INVALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0826");

    @InjectMocks
    private EquipmentStateService service;

    @Mock
    private EquipStateRepository repository;


    @BeforeEach
    void setUp() {
        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentState.class)))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());

        BDDMockito.when(repository.findAll())
                .thenReturn(List.of(EquipStateCreator.createEquipmentStateValid()));

        BDDMockito.when(repository.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipStateCreator.createEquipmentStateValid()));

        BDDMockito.doNothing().when(repository).delete(ArgumentMatchers.any(EquipmentState.class));
    }

    @Test
    @DisplayName("save - returns an equipment state when successful")
    void save_ReturnsAnEquipmentState_WhenSuccessful() {
        EquipmentState equipment = service.save(EquipStatePostRequestCreator.createEquipStatePostRequestBody());

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipStateCreator.createEquipmentStateValid());
    }

    @Test
    @DisplayName("findAll - returns a list of equipment state when successful")
    void findAll_ReturnsAListOfEquipmentState_WhenSuccessful() {
        String expectedName = EquipStateCreator.createEquipmentStateValid().getName();

        List<EquipmentState> equipments = service.findAll();

        Assertions.assertThat(equipments).isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipments.get(0).getName())
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById - returns an equipment state when successful")
    void findById_ReturnsAnEquipmentState_WhenSuccessful() throws NotFoundException {
        UUID expectedId = EquipStateCreator.createEquipmentStateValid().getId();

        EquipmentState equipment = service
                .findByIdOrThrowsNotFoundException(UUID_VALID);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getId()).isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findById - throws an exception when equipment state is not found")
    void findById_ThrowsAnException_WhenEquipmentStateNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(UUID_INVALID))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findByIdOrThrowsNotFoundException(UUID_INVALID));
    }

    @Test
    @DisplayName("update returns an equipment state when successful")
    void update_ReturnsAnEquipmentState_WhenSuccessful() throws NotFoundException {
        Assertions.assertThatCode(() -> service.update(
                        EquipStatePutRequestCreator.createEquipStatePutRequestBody()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("delete - removes an equipment state when successful")
    void delete_RemovesAnEquipmentState_WhenSuccessful() {
        Assertions.assertThatCode(() -> service.delete(UUID_VALID))
                .doesNotThrowAnyException();
    }
}