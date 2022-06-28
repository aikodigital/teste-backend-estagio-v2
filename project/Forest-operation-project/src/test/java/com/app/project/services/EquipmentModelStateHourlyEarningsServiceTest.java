package com.app.project.services;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipModelStateHourlyEarningsRepository;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentModelStateHourlyEarningsServiceTest {

    @InjectMocks
    private EquipmentModelStateHourlyEarningsService service;

    @Mock
    private EquipModelStateHourlyEarningsRepository repositoryMock;

    @Mock
    private EquipmentStateService stateServiceMock;

    @Mock
    private EquipmentModelService modelServiceMock;

    @BeforeEach
    void seuUp() throws NotFoundException {
        // modelServiceMock
        BDDMockito.when(stateServiceMock.findByIdOrThrowsNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipStateCreator.createEquipmentStateValid());

        // stateServiceMock
        BDDMockito.when(modelServiceMock.findByIdOrThrowsNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelValid());

        BDDMockito.when(repositoryMock.save(ArgumentMatchers.any(EquipmentModelStateHourlyEarnings.class)))
                .thenReturn(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid());
    }

    @Test
    @DisplayName("save - returns equipment model state hourly earnings when successful")
    void save_ReturnsEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {
        EquipmentModelStateHourlyEarnings entityToSave = service.save(
                EquipModelStateHourlyEarningsPostRequestCreator
                        .createEquipmentModelStateHourlyEarningsPostRequestCreator());
        Assertions.assertThat(entityToSave).isNotNull();
    }

}