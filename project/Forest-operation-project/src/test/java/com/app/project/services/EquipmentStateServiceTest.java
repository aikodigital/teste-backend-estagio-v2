package com.app.project.services;

import com.app.project.domain.EquipmentState;
import com.app.project.repositories.EquipStateRepository;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.util.equip.EquipCreator;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EquipmentStateServiceTest {

    @InjectMocks
    private EquipmentStateService service;

    @Mock
    private EquipStateRepository repository;

    @BeforeEach
    void setUp() {
        BDDMockito.when(repository.save(ArgumentMatchers.any(EquipmentState.class)))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());
    }

    @Test
    @DisplayName("save - returns an equipment state when successful")
    void save_ReturnsAnEquipmentState_WhenSuccessful() {
        EquipmentState equipment = service.save(EquipStatePostRequestCreator.createEquipStatePostRequestBody());

        Assertions.assertThat(equipment).isNotNull()
                .isEqualTo(EquipStateCreator.createEquipmentStateValid());
    }
}