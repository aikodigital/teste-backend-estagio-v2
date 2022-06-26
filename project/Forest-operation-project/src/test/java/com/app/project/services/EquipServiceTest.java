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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.List;

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
    @DisplayName("save - returns an equipment when successful")
    void save_ReturnsAnEquipment_WhenSuccessful() {
        Equipment equipment = service.save(
                EquipPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipCreator.createEquipmentModelValid());
    }
}