package com.app.project.controllers;

import com.app.project.domain.Equipment;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.services.EquipService;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equip.EquipPostRequestCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EquipmentControllerTest {

    @InjectMocks
    private EquipmentController controller;

    @Mock
    private EquipService service;

    @BeforeEach
    void setUp() {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipPostRequest.class)))
                .thenReturn(EquipCreator.createEquipmentModelValid());
    }

    @Test
    @DisplayName("save - Returns an equipment when successful")
    void save_ReturnsAnEquipment_WhenSuccessful() {
        Equipment equipment = controller.save(
                EquipPostRequestCreator.createEquipmentModelPostRequestBody()).getBody();

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipCreator.createEquipmentModelValid());
    }
}