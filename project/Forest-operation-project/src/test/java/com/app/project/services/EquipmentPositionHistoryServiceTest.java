package com.app.project.services;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipPositionHistoryRepository;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryCreator;
import com.app.project.util.equipPositionHistory.EquipPositionHistoryPostRequestCreator;
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

@ExtendWith(SpringExtension.class)
class EquipmentPositionHistoryServiceTest {

    @InjectMocks
    private EquipmentPositionHistoryService service;

    @Mock
    private EquipPositionHistoryRepository repository;

    @BeforeEach
    void setUp() {
// TODO: check the reason's nullPointerException
//        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentPositionHistory.class)))
//                .thenReturn(EquipPositionHistoryCreator.createEquipPositionHistoryValid());
    }
// TODO: check the reason's nullPointerException
//    @Test
//    @DisplayName("save - returns equipment position history when successful")
//    void save_ReturnsEquipmentPositionHistory_WhenSuccessful() throws NotFoundException {
//        EquipmentPositionHistory equipmentStateHistory = service.save(
//                EquipPositionHistoryPostRequestCreator.createEquipPositionHistoryPostRequestCreator());
//        Assertions.assertThat(equipmentStateHistory).isNotNull();
//    }
}