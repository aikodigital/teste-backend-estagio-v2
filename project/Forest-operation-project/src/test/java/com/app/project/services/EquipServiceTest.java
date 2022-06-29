package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipRepository;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equip.EquipPostRequestCreator;
import com.app.project.util.equip.EquipPutRequestCreator;
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
class EquipServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");
    final static UUID UUID_INVALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0826");

    @InjectMocks
    private EquipmentService service;

    @Mock
    private EquipRepository repository;

    @BeforeEach
    void setup() {
        BDDMockito.when(repository.save(ArgumentMatchers.any(Equipment.class)))
                .thenReturn(EquipCreator.createEquipmentValid());

        BDDMockito.when(repository.findAll())
                .thenReturn(List.of(EquipCreator.createEquipmentValid()));

        BDDMockito.when(repository.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipCreator.createEquipmentValid()));
    }

    @Test
    @DisplayName("findAll - returns a list of equipments when successful")
    void findAll_ReturnsAListOfEquipments_WhenSuccessful() {
        String expectedName = EquipCreator.createEquipmentValid().getName();

        List<Equipment> equipments = service.findAll();

        Assertions.assertThat(equipments).isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipments.get(0).getName())
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById - returns an equipment when successful")
    void findById_ReturnsAnEquipment_WhenSuccessful() throws NotFoundException {
        UUID expectedId = EquipCreator.createEquipmentValid().getId();

        Equipment equipment = service.findByIdOrThrowNotFoundException(UUID_VALID);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getId()).isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("getById - throws an exception when equipment is not found")
    void findById_ThrowsAnException_WhenEquipmentNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(UUID_INVALID))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findByIdOrThrowNotFoundException(UUID_INVALID));
    }

    @Test
    @DisplayName("save - returns an equipment when successful")
    void save_ReturnsAnEquipment_WhenSuccessful() {
        Equipment equipment = service.save(
                EquipPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipCreator.createEquipmentValid());
    }

    @Test
    @DisplayName("update returns an equipment when successful")
    void update_ReturnsAnEquipment_WhenSuccessful() {
        Assertions.assertThatCode(() -> service.update(
                        EquipPutRequestCreator.createEquipmentPutRequestBody()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("delete removes an equipment when successful")
    void delete_RemovesAnEquipment_WhenSuccessful() {
        Assertions.assertThatCode(() -> service.delete(UUID_VALID))
                .doesNotThrowAnyException();
    }
}