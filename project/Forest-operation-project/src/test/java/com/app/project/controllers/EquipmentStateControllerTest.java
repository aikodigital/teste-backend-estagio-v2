package com.app.project.controllers;

import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.requests.equipState.EquipStatePutRequest;
import com.app.project.services.EquipmentStateService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentStateControllerTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");

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

        BDDMockito.when(service.findByIdOrThrowsNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());

        BDDMockito.doNothing().when(service).update(ArgumentMatchers.any(EquipStatePutRequest.class));

    }

    @Test
    @DisplayName("save - Returns an equipment state when successful")
    void save_ReturnsAnEquipmentState_WhenSuccessful() throws NotFoundException {
        ResponseEntity<EquipmentState> equipment = controller.post(
                EquipStatePostRequestCreator.createEquipStatePostRequestBody());

        Assertions.assertThat(equipment.getBody()).isNotNull()
                .isEqualTo(EquipStateCreator.createEquipmentStateValid());

        Assertions.assertThat(equipment.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        BDDMockito.doNothing().when(service).delete(ArgumentMatchers.any(UUID.class));
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
        UUID expectedId = EquipStateCreator.createEquipmentStateValid().getId();

        ResponseEntity<EquipmentState> equipment = controller.getById(UUID_VALID);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getBody().getId()).isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(equipment.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("put updates an equipment state when successful")
    void put_UpdatesAnEquipmentState_WhenSuccessful() throws NotFoundException {

        Assertions.assertThatCode(() -> controller.put(
                        EquipStatePutRequestCreator.createEquipStatePutRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> updatedEquipModel = controller.put(
                EquipStatePutRequestCreator.createEquipStatePutRequestBody());

        Assertions.assertThat(updatedEquipModel).isNotNull();

        Assertions.assertThat(updatedEquipModel.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes an equipment state when successful")
    void delete_RemovesAnEquipmentState_WhenSuccessful() throws NotFoundException {
        Assertions.assertThatCode(() -> controller.delete(
                        EquipStateCreator.createEquipmentStateValid().getId()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> equipModel = controller.delete(UUID_VALID);

        Assertions.assertThat(equipModel).isNotNull();
        Assertions.assertThat(equipModel.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}