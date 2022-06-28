package com.app.project.services;

import com.app.project.repositories.EquipStateHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EquipmentStateHistoryServiceTest {

    @InjectMocks
    private EquipmentStateHistoryService service;

    @Mock
    private EquipStateHistoryRepository repository;

    @BeforeEach()
    void setUp() {
        // TODO: check the reason's nullPointerException
//        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentStateHistory.class)))
//                .thenReturn(EquipStateHistoryCreator.createEquipStateHistoryValid());
    }

    // TODO: check the reason's nullPointerException
//    @Test
//    @DisplayName("save - returns equipment state history when successful")
//    void save_ReturnsEquipmentStateHistory_WhenSuccessful() throws NotFoundException {
//        EquipmentStateHistory equipmentStateHistory = service.save(
//                EquipStateHistoryPostRequestCreator.createEquipStateHistoryPostRequestServiceCreator());
//
//        Assertions.assertThat(equipmentStateHistory).isNotNull();
//    }
}