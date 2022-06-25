package com.app.project.services;

import com.app.project.domain.EquipmentModel;
import com.app.project.repositories.EquipmentModelRepository;
import com.app.project.util.EquipmentModelCreator;
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
class EquipmentModelServiceTest {

    @InjectMocks
    private EquipmentModelService modelService;

    @Mock
    private EquipmentModelRepository modelRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(modelRepositoryMock.save(ArgumentMatchers.any(EquipmentModel.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelToBeSaved());
    }

    @Test
    @DisplayName("save returns an equipmentModel when successful")
    void save() {
        EquipmentModel equipmentModel = modelService.save(EquipmentModelCreator.createEquipmentModelToBeSaved());

        Assertions.assertThat(equipmentModel).isNotNull().isEqualTo(EquipmentModelCreator.createEquipmentModelToBeSaved());
    }
}