package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.repositories.EquipmentModelRepository;
import com.app.project.requests.EquipmentModelPutRequest;
import com.app.project.util.EquipmentModelCreator;
import com.app.project.util.EquipmentModelPostRequestCreator;
import com.app.project.util.EquipmentModelPutRequestCreator;
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

@ExtendWith(SpringExtension.class)
class EquipmentModelServiceTest {

    @InjectMocks
    private EquipmentModelService modelService;

    @Mock
    private EquipmentModelRepository modelRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(modelRepositoryMock.save(ArgumentMatchers.any(EquipmentModel.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelToBeSaved());

        BDDMockito.when(modelRepositoryMock.findAll())
                .thenReturn(List.of(EquipmentModelCreator.createEquipmentModelValid()));

        BDDMockito.when(modelRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(EquipmentModelCreator.createEquipmentModelValid()));
    }

    @Test
    @DisplayName("save returns an equipmentModel when successful")
    void save() {
        EquipmentModel equipmentModel = modelService.save(
                EquipmentModelPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipmentModel).isNotNull()
                .isEqualTo(EquipmentModelCreator.createEquipmentModelToBeSaved());
    }

    @Test
    @DisplayName("findAll returns a list of equipment models")
    void findAll_ReturnsAListOfEquipmentModels() {
        String expectedName = EquipmentModelCreator.createEquipmentModelValid().getName();

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
        Long expectedId = EquipmentModelCreator.createEquipmentModelValid().getId();

        EquipmentModel equipmentModel = modelService.findByIdOrThrowNotFoundException(1L);

        Assertions.assertThat(equipmentModel).isNotNull();

        Assertions.assertThat(equipmentModel.getId()).isNotNull()
                        .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("update - updates an equipment model when successul")
    void update_UpdateAnEquipmentModelWhenSuccessful() {
        Assertions.assertThatCode(() -> modelService.update(
                EquipmentModelPutRequestCreator.createEquipmentModelPutRequestBody()))
                .doesNotThrowAnyException();
    }
}