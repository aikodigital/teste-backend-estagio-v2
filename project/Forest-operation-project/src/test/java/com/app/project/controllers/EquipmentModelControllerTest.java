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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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

        BDDMockito.when(modelService.findAll())
                .thenReturn(List.of(EquipmentModelCreator.createEquipmentModelValid()));
    }

    @Test
    @DisplayName("post returns an equipment model when successful")
    void post_ReturnsAnEquipmentModel_WhenSuccessful() {

        EquipmentModel post = modelController.post(
                EquipmentModelPostRequestCreator.createEquipmentModelPostRequestBody()).getBody();

        Assertions.assertThat(post)
                .isNotNull()
                .isEqualTo(EquipmentModelCreator.createEquipmentModelValid());
    }

    @Test
    @DisplayName("listAll returns a list of equipment models")
    void listAll_ReturnsAListOfEquipmentModels() {
        String expectedName = EquipmentModelCreator.createEquipmentModelValid().getName();

        List<EquipmentModel> equipModels = modelController.listAll().getBody();

        Assertions.assertThat(equipModels)
                        .isNotNull()
                        .isNotEmpty()
                        .hasSize(1);

        Assertions.assertThat(equipModels.get(0).getName()).isEqualTo(expectedName);

    }
}