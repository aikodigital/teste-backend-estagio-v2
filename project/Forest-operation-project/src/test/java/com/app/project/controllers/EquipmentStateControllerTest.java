package com.app.project.controllers;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentState;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.services.EquipmentStateService;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equip.EquipPostRequestCreator;
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

@ExtendWith(SpringExtension.class)
class EquipmentStateControllerTest {

    @InjectMocks
    private EquipmentStateController controller;

    @Mock
    private EquipmentStateService service;

    @BeforeEach
    void setUp() {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipStatePostRequest.class)))
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

}