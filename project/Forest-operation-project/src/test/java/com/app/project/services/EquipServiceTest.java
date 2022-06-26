package com.app.project.services;

import com.app.project.domain.Equipment;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipRepository;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equip.EquipPostRequestCreator;
import com.app.project.util.equipModel.EquipmentModelCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EquipServiceTest {

    @InjectMocks
    private EquipService service;

    @Mock
    private EquipRepository repository;

    @BeforeEach
    void setup() {
        BDDMockito.when(repository.save(ArgumentMatchers.any(Equipment.class)))
                .thenReturn(EquipCreator.createEquipmentModelValid());

        BDDMockito.when(repository.findAll())
                .thenReturn(List.of(EquipCreator.createEquipmentModelValid()));

        BDDMockito.when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(EquipCreator.createEquipmentModelValid()));
    }

    @Test
    @DisplayName("findAll - returns a list of equipments when successful")
    void findAll_ReturnsAListOfEquipments_WhenSuccessful() {
        String expectedName = EquipCreator.createEquipmentModelValid().getName();

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
        Long expectedId = EquipCreator.createEquipmentModelValid().getId();

        Equipment equipment = service.findById(1L);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getId()).isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("getById - throws an exception when equipment is not found")
    void findById_ThrowsAnException_WhenEquipmentNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findById(1L));
    }

    @Test
    @DisplayName("save - returns an equipment when successful")
    void save_ReturnsAnEquipment_WhenSuccessful() {
        Equipment equipment = service.save(
                EquipPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipCreator.createEquipmentModelValid());
    }
}