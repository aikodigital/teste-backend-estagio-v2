package com.app.project.controllers;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPutRequest;
import com.app.project.services.EquipmentPositionHistoryService;
import com.app.project.services.EquipmentService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentPositionHistoryControllerTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");

    @InjectMocks
    private EquipmentPositionHistoryController controller;

    @Mock
    private EquipmentPositionHistoryService service;

    @Mock
    private EquipmentService equipService;

    @BeforeEach
    void setUp() throws NotFoundException {

        BDDMockito.when(service.findAll())
                .thenReturn(List.of(EquipPositionHistoryCreator.createEquipPositionHistoryValid()));

        BDDMockito.when(service.findByIdOrThrowsNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipPositionHistoryCreator.createEquipPositionHistoryValid());

        BDDMockito.when(service.save(ArgumentMatchers.any(EquipPositionHistoryPostRequest.class)))
                .thenReturn(EquipPositionHistoryCreator.createEquipPositionHistoryValid());

        BDDMockito.doNothing().when(service).update(ArgumentMatchers.any(EquipPositionHistoryPutRequest.class));
    }

    @Test
    @DisplayName("listAll - returns a list of equipment position histories when successful")
    void listAll_ReturnsAListOfEquipmentPositionHistories_WhenSuccessful() {
        String expectedName = EquipCreator.createEquipmentValid().getName();

        List<EquipmentPositionHistory> equipPositionHistory = controller.listAll().getBody();

        Assertions.assertThat(equipPositionHistory)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipPositionHistory.get(0).getEquipment().getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("getById - returns an equipment position history when successful")
    void getById_ReturnsAnEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
        UUID expectedId = EquipCreator.createEquipmentValid().getId();

        ResponseEntity<EquipmentPositionHistory> equipment = controller.getById(UUID_VALID);

        Assertions.assertThat(equipment).isNotNull();

        Assertions.assertThat(equipment.getBody().getId()).isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(equipment.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("save - Returns an equipment position history when successful")
    void save_ReturnsAnEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
        EquipmentPositionHistory equipment = controller.post(
                EquipPositionHistoryPostRequestCreator.createEquipPositionHistoryPostRequestCreator()).getBody();

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipPositionHistoryCreator.createEquipPositionHistoryValid());
    }

    @Test
    @DisplayName("put updates an equipment position history when successful")
    void put_UpdatesAnEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {

        Assertions.assertThatCode(() -> controller.put(
                        EquipPositionHistoryPutRequestCreator.createEquipPositionHistoryPutRequestCreator()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> updatedEquip = controller.put(
                EquipPositionHistoryPutRequestCreator.createEquipPositionHistoryPutRequestCreator());

        Assertions.assertThat(updatedEquip).isNotNull();

        Assertions.assertThat(updatedEquip.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes an equipment position history when successful")
    void delete_RemovesAnEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
        Assertions.assertThatCode(() -> controller.delete(
                        EquipPositionHistoryCreator.createEquipPositionHistoryValid().getId()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> equip = controller.delete(UUID_VALID);

        Assertions.assertThat(equip).isNotNull();
        Assertions.assertThat(equip.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}