package com.app.project.controllers;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPutRequest;
import com.app.project.services.EquipmentModelStateHourlyEarningsService;
import com.app.project.util.equipModel.EquipModelCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequestCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPutRequestCreator;
import com.app.project.util.equipState.EquipStateCreator;
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
class EquipmentModelStateHourlyEarningsControllerTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");

    @InjectMocks
    private EquipmentModelStateHourlyEarningsController controller;

    @Mock
    private EquipmentModelStateHourlyEarningsService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipModelStateHourlyEarningsPostRequest.class)))
                .thenReturn(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid());

        BDDMockito.when(service.findAll())
                .thenReturn(List.of(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid()));

        BDDMockito.when(service.findByIdOrThrowsNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid());

        BDDMockito.doNothing().when(service).update(
                ArgumentMatchers.any(EquipModelStateHourlyEarningsPutRequest.class));
    }

    @Test
    @DisplayName("listAll - returns a list of equipment model state hourly earnings when successful")
    void listAll_ReturnsAListOfEquipmentModelStateHourlyEarnings_WhenSuccessful() {
        UUID expectedStateId = EquipStateCreator.createEquipmentStateValid().getId();
        UUID expectedModelId = EquipModelCreator.createEquipmentModelValid().getId();

        List<EquipmentModelStateHourlyEarnings> entity = controller.listAll().getBody();

        Assertions.assertThat(entity)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(entity.get(0).getEquipmentState().getId()).isEqualTo(expectedStateId);
        Assertions.assertThat(entity.get(0).getEquipmentModel().getId()).isEqualTo(expectedModelId);
    }

    @Test
    @DisplayName("getById - returns an equipment model state hourly earnings when successful")
    void getById_ReturnsAnEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {
        UUID expectedStateId = EquipStateCreator.createEquipmentStateValid().getId();
        UUID expectedModelId = EquipModelCreator.createEquipmentModelValid().getId();

        EquipmentModelStateHourlyEarnings entity = controller.getById(UUID_VALID).getBody();

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getEquipmentModel().getId())
                .isEqualTo(expectedModelId);

        Assertions.assertThat(entity.getEquipmentState().getId())
                .isEqualTo(expectedStateId);
    }

    @Test
    @DisplayName("save - Returns an equipment model state hourly earnings when successful")
    void save_ReturnsAnEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {
        ResponseEntity<EquipmentModelStateHourlyEarnings> entity = controller.post(
                EquipModelStateHourlyEarningsPostRequestCreator
                        .createEquipmentModelStateHourlyEarningsPostRequestCreator());

        Assertions.assertThat(entity.getBody()).isNotNull()
                .isEqualTo(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid());

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("put updates an equipment model state hourly earnings when successful")
    void put_UpdatesAnEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {

        Assertions.assertThatCode(() -> controller.put(
                        EquipModelStateHourlyEarningsPutRequestCreator
                                .createEquipModelStateHourlyEarningsPostRequestCreator()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> updatedEquip = controller.put(
                EquipModelStateHourlyEarningsPutRequestCreator
                        .createEquipModelStateHourlyEarningsPostRequestCreator());

        Assertions.assertThat(updatedEquip).isNotNull();

        Assertions.assertThat(updatedEquip.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes an equipment model state hourly earnings when successful")
    void delete_RemovesAnEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {
        Assertions.assertThatCode(() -> controller.delete(
                        EquipModelStateHourlyEarningsCreator
                                .createEquipmentModelStateHourlyEarningsValid().getId()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> equip = controller.delete(UUID_VALID);

        Assertions.assertThat(equip).isNotNull();
        Assertions.assertThat(equip.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}