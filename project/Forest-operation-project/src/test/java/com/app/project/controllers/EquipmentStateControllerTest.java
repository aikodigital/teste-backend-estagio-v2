package com.app.project.controllers;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.services.EquipmentStateService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class EquipmentStateControllerTest {

    @InjectMocks
    private EquipmentStateController controller;

    @Mock
    private EquipmentStateService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipStatePostRequest.class)))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());

        BDDMockito.when(service.findAll())
                .thenReturn(List.of(EquipStateCreator.createEquipmentStateValid()));

        BDDMockito.when(service.findById(ArgumentMatchers.anyLong()))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());
    }

    @Test
    @DisplayName("save - Returns an equipment state when successful")
    void save_ReturnsAnEquipmentState_WhenSuccessful() {
        ResponseEntity<EquipmentState> equipment = controller.post(
                EquipStatePostRequestCreator.createEquipStatePostRequestBody());

        Assertions.assertThat(equipment.getBody()).isNotNull()
                .isEqualTo(EquipStateCreator.createEquipmentStateValid());

        Assertions.assertThat(equipment.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("listAll - returns a list of equipments state when successful")
    void listAll_ReturnsAListOfEquipmentsState_WhenSuccessful() {
        String expectedName = EquipStateCreator.createEquipmentStateValid().getName();

        List<EquipmentState> equipModels = controller.findAll().getBody();

        Assertions.assertThat(equipModels)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipModels.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("getById - returns an equipment state when successful")
    void getById_ReturnsAnEquipmentState_WhenSuccessful() throws NotFoundException {
        Long expectedId = EquipStateCreator.createEquipmentStateValid().getId();

        ResponseEntity<EquipmentState> equipment = controller.getById(1L);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getBody().getId()).isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(equipment.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }
}