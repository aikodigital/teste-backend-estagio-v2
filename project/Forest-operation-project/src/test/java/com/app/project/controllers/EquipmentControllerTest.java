package com.app.project.controllers;

import com.app.project.domain.Equipment;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.requests.equip.EquipPutRequest;
import com.app.project.services.EquipService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class EquipmentControllerTest {

    @InjectMocks
    private EquipmentController controller;

    @Mock
    private EquipService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipPostRequest.class)))
                .thenReturn(EquipCreator.createEquipmentValid());

        BDDMockito.when(service.findAll())
                .thenReturn(List.of(EquipCreator.createEquipmentValid()));

        BDDMockito.when(service.findByIdOrThrowNotFoundException(ArgumentMatchers.anyLong()))
                .thenReturn(EquipCreator.createEquipmentValid());

        BDDMockito.doNothing().when(service).update(ArgumentMatchers.any(EquipPutRequest.class));
    }

    @Test
    @DisplayName("listAll - returns a list of equipments when successful")
    void listAll_ReturnsAListOfEquipments_WhenSuccessful() {
        String expectedName = EquipCreator.createEquipmentValid().getName();

        List<Equipment> equipModels = controller.listAll().getBody();

        Assertions.assertThat(equipModels)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipModels.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("getById - returns an equipment when successful")
    void findById_ReturnsAnEquipment_WhenSuccessful() throws NotFoundException {
        Long expectedId = EquipCreator.createEquipmentValid().getId();

        ResponseEntity<Equipment> equipment = controller.getById(1L);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getBody().getId()).isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(equipment.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("save - Returns an equipment when successful")
    void save_ReturnsAnEquipment_WhenSuccessful() {
        ResponseEntity<Equipment> equipment = controller.save(
                EquipPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipment.getBody()).isNotNull()
                .isEqualTo(EquipCreator.createEquipmentValid());

        Assertions.assertThat(equipment.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("put updates an equipment when successful")
    void put_UpdatesAnEquipment_WhenSuccessful() throws NotFoundException {

        Assertions.assertThatCode(() -> controller.put(
                        EquipPutRequestCreator.createEquipmentPutRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> updatedEquipModel = controller.put(
                EquipPutRequestCreator.createEquipmentPutRequestBody());

        Assertions.assertThat(updatedEquipModel).isNotNull();

        Assertions.assertThat(updatedEquipModel.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }
}