package com.app.project.controllers;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.services.EquipmentPositionHistoryService;
import com.app.project.services.EquipmentStateService;
import com.app.project.util.equipModel.EquipmentModelCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryPostRequestCreator;
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
class EquipmentPositionHistoryControllerTest {

    @InjectMocks
    private EquipmentPositionHistoryController controller;

    @Mock
    private EquipmentPositionHistoryService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipPositionHistoryPostRequest.class)))
                .thenReturn(EquipPositionHistoryCreator.createEquipPositionHistoryValid());
    }

    @Test
    @DisplayName("save - Returns an equipment position history when successful")
    void save_ReturnsAnEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
        EquipmentPositionHistory equipment = controller.post(
                EquipPositionHistoryPostRequestCreator.createEquipPositionHistoryPostRequestCreator()).getBody();

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipPositionHistoryCreator.createEquipPositionHistoryValid());
    }
}