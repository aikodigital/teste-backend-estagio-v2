package com.app.project.controllers;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.services.EquipmentStateHistoryService;
import com.app.project.util.equipStateHistory.EquipStateHistoryCreator;
import com.app.project.util.equipStateHistory.EquipStateHistoryPostRequestCreator;
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

@ExtendWith(SpringExtension.class)
class EquipmentStateHistoryControllerTest {

    @InjectMocks
    private EquipmentStateHistoryController controller;

    @Mock
    private EquipmentStateHistoryService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipStateHistoryPostRequest.class)))
                .thenReturn(EquipStateHistoryCreator.createEquipStateHistoryValid());
    }

    @Test
    @DisplayName("save returns equipment state history when successful")
    void save_ReturnsEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
        EquipmentStateHistory equipmentStateHistory = controller.post(
                EquipStateHistoryPostRequestCreator.createEquipStateHistoryPostRequestCreator()).getBody();

        Assertions.assertThat(equipmentStateHistory).isNotNull()
                .isEqualTo(EquipStateHistoryCreator.createEquipStateHistoryValid());
    }

}