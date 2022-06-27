package com.app.project.services;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipStateRepository;
import com.app.project.util.equipState.EquipStateCreator;
import com.app.project.util.equipState.EquipStatePostRequestCreator;
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

@ExtendWith(SpringExtension.class)
class EquipmentStateServiceTest {

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

        BDDMockito.when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(EquipStateCreator.createEquipmentStateValid()));
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
        Long expectedId = EquipStateCreator.createEquipmentStateValid().getId();

        EquipmentState equipment = service.findById(1L);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getId()).isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findById - throws an exception when equipment state is not found")
    void findById_ThrowsAnException_WhenEquipmentStateNotFound() throws NotFoundException {
        BDDMockito.when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findById(1L));
    }
}