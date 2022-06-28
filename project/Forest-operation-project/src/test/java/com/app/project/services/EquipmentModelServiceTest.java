package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipModelRepository;
import com.app.project.util.equipModel.EquipModelCreator;
import com.app.project.util.equipModel.EquipModelPostRequestCreator;
import com.app.project.util.equipModel.EquipModelPutRequestCreator;
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
class EquipmentModelServiceTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");

    @InjectMocks
    private EquipmentModelService modelService;

    @Mock
    private EquipModelRepository modelRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(modelRepositoryMock.save(ArgumentMatchers.any(EquipmentModel.class)))
                .thenReturn(EquipModelCreator.createEquipmentModelToBeSaved());

        BDDMockito.when(modelRepositoryMock.findAll())
                .thenReturn(List.of(EquipModelCreator.createEquipmentModelValid()));

        BDDMockito.when(modelRepositoryMock.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.ofNullable(EquipModelCreator.createEquipmentModelValid()));

        BDDMockito.doNothing().when(modelRepositoryMock).delete(ArgumentMatchers.any(EquipmentModel.class));
    }

    @Test
    @DisplayName("findAll returns a list of equipment models")
    void findAll_ReturnsAListOfEquipmentModels_WhenSuccessful() {
        String expectedName = EquipModelCreator.createEquipmentModelValid().getName();

        List<EquipmentModel> equipModels = modelService.findAll();

        Assertions.assertThat(equipModels)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipModels.get(0).getName())
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById returns an equipment model when successful")
    void findById_ReturnsAnEquipmentModel_WhenSuccessful() throws NotFoundException {
        UUID expectedId = EquipModelCreator.createEquipmentModelValid().getId();

        EquipmentModel equipmentModel = modelService
                .findByIdOrThrowsNotFoundException(UUID_VALID);

        Assertions.assertThat(equipmentModel).isNotNull();

        Assertions.assertThat(equipmentModel.getId()).isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("save returns an equipmentModel when successful")
    void saveReturnsAnEquipmentModel_WhenSuccessful() {
        EquipmentModel equipmentModel = modelService.save(
                EquipModelPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipmentModel).isNotNull()
                .isEqualTo(EquipModelCreator.createEquipmentModelToBeSaved());
    }

    @Test
    @DisplayName("update - updates an equipment model when successful")
    void update_UpdateAnEquipmentModel_WhenSuccessful() {
        Assertions.assertThatCode(() -> modelService.update(
                        EquipModelPutRequestCreator.createEquipmentModelPutRequestBody()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("delete removes an equipment model when successful")
    void delete_RemovesAnEquipmentModel_WhenSuccessful() {
        Assertions.assertThatCode(() -> modelService
                        .delete(UUID_VALID))
                .doesNotThrowAnyException();
    }
}