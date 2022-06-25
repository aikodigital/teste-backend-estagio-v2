package com.app.project.controllers;

import com.app.project.domain.EquipmentModel;
import com.app.project.requests.EquipmentModelPostRequest;
import com.app.project.services.EquipmentModelService;
import com.app.project.util.EquipmentModelCreator;
import com.app.project.util.EquipmentModelPostRequestCreator;
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
class EquipmentModelControllerTest {

    @InjectMocks
    private EquipmentModelController modelController;

    @Mock
    private EquipmentModelService modelService;

    @BeforeEach
    void setUp() {
        BDDMockito.when(modelService.save(ArgumentMatchers.any(EquipmentModelPostRequest.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelValid());
    }

    @Test
    @DisplayName("post returns an equipment model when successful")
    void post_ReturnsAnEquipmentModel_WhenSuccessful() {

        EquipmentModel equipmentModel = modelService.save(
                EquipmentModelPostRequestCreator.createEquipmentModelPostRequestBody());

        Assertions.assertThat(equipmentModel)
                .isNotNull()
                .isEqualTo(EquipmentModelCreator.createEquipmentModelValid());
    }
}