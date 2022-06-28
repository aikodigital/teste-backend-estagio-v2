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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentModelStateHourlyEarningsServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");
    final static UUID UUID_INVALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0826");

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

        BDDMockito.when(repositoryMock.findAll())
                .thenReturn(List.of(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid()));

        BDDMockito.when(repositoryMock.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid()));
    }

    @Test
    @DisplayName("findAll - returns a list of equipment model state hourly earnings when successful")
    void findAll_ReturnsAListOfEquipmentModelStateHourlyEarnings_WhenSuccessful() {
        UUID expectedIdEquipState = EquipStateCreator.createEquipmentStateValid().getId();
        UUID expectedIdEquipModel = EquipmentModelCreator.createEquipmentModelValid().getId();

        List<EquipmentModelStateHourlyEarnings> entity = service.findAll();

        Assertions.assertThat(entity).isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(entity.get(0).getEquipmentModel().getId())
                .isEqualTo(expectedIdEquipState);
        Assertions.assertThat(entity.get(0).getEquipmentState().getId())
                .isEqualTo(expectedIdEquipModel);
    }

    @Test
    @DisplayName("findById - returns an equipment model state hourly earning when successful")
    void findById_ReturnsAnEquipmentModelStateHourlyEarnings_WhenSuccessful() throws NotFoundException {
        UUID expectedStateId = EquipStateCreator.createEquipmentStateValid().getId();
        UUID expectedModelId = EquipmentModelCreator.createEquipmentModelValid().getId();

        EquipmentModelStateHourlyEarnings entity = service
                .findByIdOrThrowsNotFoundException(UUID_VALID);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getEquipmentState().getId()).isNotNull()
                .isEqualTo(expectedStateId);
        Assertions.assertThat(entity.getEquipmentModel().getId()).isNotNull()
                .isEqualTo(expectedModelId);
    }

    @Test
    @DisplayName("findById - throws an exception when equipment model state hourly earnings is not found")
    void findById_ThrowsAnException_WhenEquipmentModelStateHourlyEarningsNotFound() throws NotFoundException {
        BDDMockito.when(repositoryMock.findById(UUID_INVALID))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> service.findByIdOrThrowsNotFoundException(UUID_INVALID));
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