package com.app.project.controllers;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.services.EquipmentStateHistoryService;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equipState.EquipStateCreator;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentStateHistoryControllerTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");


    @InjectMocks
    private EquipmentStateHistoryController controller;

    @Mock
    private EquipmentStateHistoryService service;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(service.save(ArgumentMatchers.any(EquipStateHistoryPostRequest.class)))
                .thenReturn(EquipStateHistoryCreator.createEquipStateHistoryValid());

        BDDMockito.when(service.findAll())
                .thenReturn(List.of(EquipStateHistoryCreator.createEquipStateHistoryValid()));

        BDDMockito.when(service.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipStateHistoryCreator.createEquipStateHistoryValid());
    }

    @Test
    @DisplayName("listAll - returns a list of equipment states histories when successful")
    void listAll_ReturnsAListOfEquipmentStatesHistories_WhenSuccessful() {
        UUID expectedEquipId = EquipCreator.createEquipmentValid().getId();
        UUID expectedEquipStateId = EquipStateCreator.createEquipmentStateValid().getId();

        List<EquipmentStateHistory> equipmentStateHistory = controller.listAll().getBody();

        Assertions.assertThat(equipmentStateHistory)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipmentStateHistory.get(0)
                .getEquipment().getId()).isEqualTo(expectedEquipId);
        Assertions.assertThat(equipmentStateHistory.get(0)
                .getEquipmentState().getId()).isEqualTo(expectedEquipStateId);
    }

    @Test
    @DisplayName("getById - returns equipment state history when successful")
    void getById_ReturnsEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
        UUID expectedEquipId = EquipCreator.createEquipmentValid().getId();
        UUID expectedEquipStateId = EquipStateCreator.createEquipmentStateValid().getId();

        EquipmentStateHistory equipmentStateHistory = controller.getById(UUID_VALID).getBody();

        Assertions.assertThat(equipmentStateHistory)
                .isNotNull();

        Assertions.assertThat(equipmentStateHistory.getEquipment().getId()).isEqualTo(expectedEquipId);
        Assertions.assertThat(equipmentStateHistory.getEquipmentState().getId()).isEqualTo(expectedEquipStateId);
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