package com.app.project.controllers;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.EquipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;
import com.app.project.services.EquipmentModelStateHourlyEarningsService;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsCreator;
import com.app.project.util.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequestCreator;
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

import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentModelStateHourlyEarningsControllerTest {

    @InjectMocks
    private EquipmentModelStateHourlyEarningsController controller;

    @Mock
    private EquipmentModelStateHourlyEarningsService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipModelStateHourlyEarningsPostRequest.class)))
                .thenReturn(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid());
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