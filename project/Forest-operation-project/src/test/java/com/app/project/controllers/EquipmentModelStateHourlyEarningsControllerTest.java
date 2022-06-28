package com.app.project.controllers;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.EquipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.services.EquipmentModelStateHourlyEarningsService;
import com.app.project.util.equipModel.EquipmentModelCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequestCreator;
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
    }

    @Test
    @DisplayName("listAll - returns a list of equipment model state hourly earnings when successful")
    void listAll_ReturnsAListOfEquipmentModelStateHourlyEarnings_WhenSuccessful() {
        UUID expectedStateId = EquipStateCreator.createEquipmentStateValid().getId();
        UUID expectedModelId = EquipmentModelCreator.createEquipmentModelValid().getId();

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
        UUID expectedModelId = EquipmentModelCreator.createEquipmentModelValid().getId();

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
}